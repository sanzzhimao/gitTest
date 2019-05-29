 class XiYou{
	
		private String weapon;
		private String zdl;
		private String nl;
		private String name;
		
		public String getName() {
			return name;
		}
		 public void setName(String name) {
			 this.name = name;
		 }
		 
		 public String getWeapon() {
			 return weapon;
		 }
		 public void setWeapon(String weapon) {
			 this.weapon = weapon;
		 }
		 
		 public String getZdl() {
			 return zdl;
		 }
		 public void setZdl(String zdl) {
			 this.zdl = zdl;
		 }
		 
		 public String getNl() {
			 return nl;
		 }
		 public void setNl(String nl) {
			 this.nl = nl;
		 }
		 
		 public void show1() {
			 System.out.println(getName()+" ÎäÆ÷£º"+getWeapon()+"   Õ½¶·Á¦£º"+getZdl()+"   ÄÍÁ¦£º"+getNl());
		 }
}

public class XiYouJi {

	public static void main(String[] args) {
	
		XiYou sun = new XiYou();
		sun.setName("ËïÎò¿Õ");
		sun.setWeapon("½ð¹¿°ô");
		sun.setZdl("Îå¿ÅÐÇ");
		sun.setNl("Îå¿ÅÐÇ");
		sun.show1();
		
		XiYou tang = new XiYou();
		tang.setName("ÌÆÉ®    ");
		tang.setWeapon("ÎÞ          ");
		tang.setZdl("Áã         ");
		tang.setNl("Îå¿ÅÐÇ");
		tang.show1();
		
		XiYou zhu = new XiYou();
		zhu.setName("Öí°Ë½ä");
		zhu.setWeapon("°Ò×Ó    ");
		zhu.setZdl("ËÄ¿ÅÐÇ");
		zhu.setNl("ËÄ¿ÅÐÇ");
		zhu.show1();
		
		XiYou sha = new XiYou();
		sha.setName("É³É®    ");
		sha.setWeapon("ÔÂÑÀ²ù");
		sha.setZdl("Èý¿ÅÐÇ");
		sha.setNl("ËÄ¿ÅÐÇ");
		sha.show1();
	
	}
	
}
