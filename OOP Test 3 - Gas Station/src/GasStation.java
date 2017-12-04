import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GasStation {	
	private static final String TOTAL_FUEL_SOLD = "SELECT fuel_type, SUM(fuel_quantity) AS total FROM station_loadings GROUP BY fuel_type";
	private static final String BY_CARS_SERVICED = "SELECT kolonka_id, COUNT(loading_time) AS automobiles FROM station_loadings GROUP BY kolonka_id";
	private static final String FUEL_BY_COLUMNS = "SELECT kolonka_id, fuel_type, fuel_quantity, loading_time FROM station_loadings ORDER BY kolonka_id";

	private ArrayList<Worker> workers;
	private ArrayList<Cashier> cashiers;
	private ArrayList<GasDispenser> columns;
	private Register register;
	private HashMap<LocalDate, ArrayList<Receipt>> archive;
	
	public GasStation(){
		this.archive = new HashMap<>();
		this.workers = new ArrayList<Worker>();
		this.cashiers = new ArrayList<Cashier>();
		this.register = new Register();
		this.columns = new ArrayList<GasDispenser>();
		for(int i = 0; i < 5; i++){
			this.columns.add(new GasDispenser());
			if(i < 2){
				this.workers.add(new Worker());
				this.cashiers.add(new Cashier());
			}
		}
		Staff.setWorkplace(this);
	}
	
	public int sizeof(){
		return this.archive.size();
	}
	
	public Register getRegister() {
		return register;
	}
	
	public ArrayList<GasDispenser> getColumns() {
		return columns;
	}
	
	public void archiveReceipt(Receipt r) {
		if(!this.archive.containsKey(LocalDate.now())){
			this.archive.put(LocalDate.now(), new ArrayList<Receipt>());
		}
		this.archive.get(LocalDate.now()).add(r);
		
		Connection con = getCon();
		try {
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO station_loadings (kolonka_id, fuel_type, fuel_quantity, loading_time) VALUES(?, ?, ?, ?)");
			ps.setInt(1, r.getColumn());
			ps.setInt(2, r.getType());
			ps.setInt(3, r.getGasLoaded());
			ps.setString(4, r.getDate().toString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void serviceCar(Car car) {
		this.columns.get(new Random().nextInt(this.columns.size())).addCar(car);		
	}
	
	public void generateReport(boolean files) {
		generateByFuel(files);
		generateByService(files);
		generateByTotalFuel(files);
		generateRevenueByFuelType(files);
	}
	
	public void startGeneratingReports(boolean files){
		Reporter report = new Reporter(files);
		report.setDaemon(true);
		report.start();
	}
	
	public void startWork(){
		for(Worker w : workers){
			Thread sad = w;
			sad.start();
		}
		for(Cashier c : cashiers){
			Thread sad = c;
			sad.start();
		}
	}
	
	
	private Connection getCon(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Rip");
		}
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr?autoReconnect=true&useSSL=false", "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	private PrintWriter getPrintWriter(File f){
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pw;
	}

	private void generateByFuel(boolean files){
		Statement st = null;
		boolean zapis = files;
		PrintWriter pw = null;
		if(zapis){
			File f = new File("report-1-" + LocalDate.now().toString() + ".txt");
			pw = getPrintWriter(f);
		}
		try {
			st = getCon().createStatement();
		} catch (SQLException e) {
			System.out.println("sad");
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(FUEL_BY_COLUMNS);
			int kolnum = 0;
			while(rs.next()){
				int col = rs.getInt("kolonka_id");
				if(kolnum != col){
					System.out.println("Kolonka " + col + ": ");
					if(zapis) pw.print("Kolonka " + col + ": ");
					kolnum = col;
				}
				// 0 benzin , 1 dizel, 2 gas - za po - byrzo
				String data = rs.getInt("fuel_type") + ", " + rs.getInt("fuel_quantity") + " litra, " + rs.getString("loading_time");
				System.out.println(data);
				if(zapis) pw.println(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pw.close();
		}
		
	}
	
	private void generateByService(boolean files){
		boolean zapis = files;
		Statement st = null;
		PrintWriter pw = null;
		if(zapis){
			File f = new File("report-2-" + LocalDate.now().toString() + ".txt");
			pw = getPrintWriter(f);
		}
		try {
			st = getCon().createStatement();
		} catch (SQLException e) {
			System.out.println("sad");
		}
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(BY_CARS_SERVICED);
			while(rs.next()){
				String data = "Kolonka " + rs.getInt("kolonka_id") + " " + rs.getInt("automobiles") + " avtomobila";
				System.out.println(data);
				if(zapis) pw.println(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			pw.close();
		}
	}
	
	private void generateByTotalFuel(boolean files){
		boolean zapis = files;
		Statement st = null;
		PrintWriter pw = null;
		if(zapis){
			File f = new File("report-3-" + LocalDate.now().toString() + ".txt");
			pw = getPrintWriter(f);
		}
		try {
			st = getCon().createStatement();
		} catch (SQLException e) {
			System.out.println("sad");
		}
		ResultSet rs = null;
		
		try{
			rs = st.executeQuery(TOTAL_FUEL_SOLD);
			while(rs.next()){
				String data = rs.getInt("fuel_type") + rs.getInt("total") + " litra";
				System.out.println(data);
				if(zapis) pw.println(data);
			}
		}catch(SQLException e){
			
		}finally {
			pw.close();
		}
	}
	
	private void generateRevenueByFuelType(boolean files){
		boolean zapis = files;
		Statement st = null;
		PrintWriter pw = null;
		if(zapis){
			File f = new File("report-4-" + LocalDate.now().toString() + ".txt");
			pw = getPrintWriter(f);
		}
		try {
			st = getCon().createStatement();
		} catch (SQLException e) {
			System.out.println("sad");
		}
		ResultSet rs = null;
		
		try{
			rs = st.executeQuery(TOTAL_FUEL_SOLD);
			while(rs.next()){
				String data = null;
				// 0 benzin , 1 dizel, 2 gas - za po - byrzo
				switch(rs.getInt("fuel_type")){
				case 0:
					data = "Benzin: " + (rs.getInt("total")*2) + " leva";
					break;
				case 1:
					data = "Dizel: " + (rs.getInt("total")*2.4) + " leva";
					break;
				case 2:
					data = "Gaz: " + (rs.getInt("total")*1.6) + " leva";
					break;
				}
				
				System.out.println(data);
				if(zapis) pw.println(data);
			}
		}
		catch(SQLException e){
			
		}
		finally{
			pw.close();
		}
	}
	
	private class Reporter extends Thread {
		
		boolean files;
		
		public Reporter(boolean files){
			this.files = files;
		}
		
		@Override
		public void run() {
			while(true){
				try {
//					Thread.sleep(24*60*60*1000);
					Thread.sleep(60*1000);
				} catch (InterruptedException e) {
					System.out.println("rip man");
				}
				
				generateReport(files);
				
				try {
					Thread.sleep(5*60*1000);
				} catch (InterruptedException e) {
					System.out.println("super sad");
				}
			}
		}
	}
}