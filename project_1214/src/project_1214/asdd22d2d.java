//	void insert(String a, String b, String c) {
//		Student stu = null;
//		
//		stu.name = a;
//		stu.hakbun = b;
//		stu.addr = c;	
//		
//		String sql = "insert into student1(id,name,hakbun,address) values (0,?,?,?)";
//		try {
//			pstm = conn.prepareStatement(sql);
//			pstm.setString(1, a);
//			pstm.setString(2, b);
//			pstm.setString(3, c);
//			pstm.executeUpdate();
//			System.out.println("입력 성공");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstm != null) {
//				try {
//					pstm.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}