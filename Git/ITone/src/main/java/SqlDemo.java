import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SqlDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/new_schema?useSSL=false";
        final String USER = "root";
        final String PASS = "123456";
            Connection conn = null;
            Statement stmt = null;
            try{
                // 注册 JDBC 驱动
                Class.forName(JDBC_DRIVER);

                // 打开链接
                System.out.println("连接数据库...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                // 执行查询
                System.out.println(" 实例化Statement对象...");
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT * FROM test";
                ResultSet rs = stmt.executeQuery(sql);

                // 展开结果集数据库
                while(rs.next()){
                    // 通过字段检索
                    int id  = rs.getInt("id");
                    Date create_at = rs.getDate("create_at");
                    Date update_at = rs.getDate("update_at");
                    String name = rs.getString("name");
                    int qq = rs.getInt("id");

                    // 输出数据
                    System.out.print("ID: " + id);
                    System.out.print(", create_at: " + create_at);
                    System.out.print(", update_at: " + update_at);
                    System.out.print(", name: " + name);
                    System.out.print(", qq: " + qq);
                    System.out.print("\n");
                }
                // 完成后关闭
                rs.close();
                stmt.close();
                conn.close();
            }catch(SQLException se){
                // 处理 JDBC 错误
                se.printStackTrace();
            }catch(Exception e){
                // 处理 Class.forName 错误
                e.printStackTrace();
            }finally{
                // 关闭资源
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){
                }// 什么都不做
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }

            //执行delete语句
            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("连接数据库...");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                System.out.print("请输入删除的用户:");
                Scanner input = new Scanner(System.in);
                int id = input.nextInt();
                String deleteSql = "DELETE FROM test WHERE id="+id+";";
                stmt = conn.createStatement();
                stmt.executeUpdate(deleteSql);
                System.out.printf("success");
            }
            catch(SQLException se){
                // 处理 JDBC 错误
                se.printStackTrace();
            }catch(Exception e){
                // 处理 Class.forName 错误
                e.printStackTrace();
            }finally{
                // 关闭资源
                try{
                    if(stmt!=null) stmt.close();
                }catch(SQLException se2){
                }// 什么都不做
                try{
                    if(conn!=null) conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }

            //执行add语句
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Scanner input1 = new Scanner(System.in);
            System.out.print("请输入用户id:");
            int id = input1.nextInt();
            System.out.print("请输入create_at:");
            String create_at =input1.next();
            System.out.print("请输入update_at:");
            String update_at =input1.next();
            System.out.print("请输入name:");
            String name =input1.next();
            System.out.print("请输入qq:");
            int qq =input1.nextInt();
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String addSql  =
            "INSERT INTO test VALUES ('"+id+"', '"+create_at+"', '"+update_at+"', '"+name+"', '"+qq+"');";
            stmt = conn.createStatement();
            stmt.executeUpdate(addSql);
            System.out.printf("success");
        }
        catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

        //执行update语句
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.print("请输入修改的用户ID:");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            System.out.print("请输入新的name:");
            String name = input.next();
            String UpdateSql = "UPDATE test SET name = '"+name+"' WHERE id = "+id+";";
            PreparedStatement ps = conn.prepareStatement(UpdateSql);
            ps.executeUpdate();
            System.out.println("success");
        }
        catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
            System.out.println("Goodbye!");
    }
}
