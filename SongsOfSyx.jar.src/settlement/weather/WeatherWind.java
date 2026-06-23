/*     */ package settlement.weather;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DOUBLE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class WeatherWind
/*     */   extends WeatherThing
/*     */ {
/*  15 */   private static CharSequence ¤¤name = "Wind";
/*  16 */   private static CharSequence ¤¤desc = "Wind Strength"; private final double MAX = 1.0D; private double target; private double dayM;
/*     */   
/*     */   static {
/*  19 */     D.ts(WeatherWind.class);
/*     */   }
/*     */   private double speed; private int day; private double t; public final DOUBLE time;
/*     */   WeatherWind() {
/*  23 */     super(¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  29 */     this.MAX = 1.0D;
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.speed = 0.1D;
/*  34 */     this.day = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.time = new DOUBLE()
/*     */       {
/*     */         public double getD()
/*     */         {
/* 106 */           return WeatherWind.this.t;
/*     */         }
/*     */       };
/*     */     this.target = RND.rFloat();
/*     */     setD(RND.rFloat());
/*     */     this.dayM = -0.5D + RND.rFloat();
/*     */   }
/*     */   
/*     */   protected void update(double ds) {
/*     */     double next = adjustTowards(getD(), ds * this.speed, this.target);
/*     */     if (next == getD())
/*     */       reset(); 
/*     */     setD(CLAMP.d(next, 0.0D, 1.0D));
/*     */     this.t += ds * getD();
/*     */     if (this.t > 2.147483647E9D)
/*     */       this.t -= 2.147483647E9D; 
/*     */   }
/*     */   
/*     */   private void reset() {
/*     */     if (this.day != TIME.days().bitsSinceStart()) {
/*     */       this.day = TIME.days().bitsSinceStart();
/*     */       this.dayM = -0.5D + RND.rFloat();
/*     */     } 
/*     */     this.target = CLAMP.d(this.dayM + RND.rFloat(), 0.0D, 1.0D);
/*     */     this.speed = 0.1D * (0.25D + RND.rFloat() * 0.75D);
/*     */   }
/*     */   
/*     */   public void setDayTarget(double target) {
/*     */     this.dayM = target;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/*     */     file.d(this.target);
/*     */     file.d(this.dayM);
/*     */     file.d(this.t);
/*     */     file.i(this.day);
/*     */     super.save(file);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*     */     this.target = file.d();
/*     */     this.dayM = file.d();
/*     */     this.t = file.d();
/*     */     this.day = file.i();
/*     */     super.load(file);
/*     */   }
/*     */   
/*     */   public double x() {
/*     */     return -getD();
/*     */   }
/*     */   
/*     */   public double y() {
/*     */     return -getD();
/*     */   }
/*     */   
/*     */   public double dirX() {
/*     */     return -1.0D;
/*     */   }
/*     */   
/*     */   public double dirY() {
/*     */     return 1.0D;
/*     */   }
/*     */   
/*     */   protected void init() {
/*     */     reset();
/*     */     setD(this.target);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherWind.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */