/*    */ package settlement.weather;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.audio.AUDIO;
/*    */ import game.time.TIME;
/*    */ import init.settings.S;
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.light.AmbientLight;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherThunder extends WeatherThing {
/* 14 */   private final AmbientLight flash = new AmbientLight();
/*    */   
/*    */   private double flashI;
/*    */   private boolean flashIs;
/*    */   private static final float thunderTimer = 4.0F;
/*    */   private static final float thunderLength = 0.2F;
/* 20 */   private float timer1 = RND.rFloat() * 4.0F;
/* 21 */   private float timer2 = RND.rFloat() * 0.2F;
/* 22 */   private double soundTimer = 1.0D;
/*    */   
/*    */   private double target;
/* 25 */   private static CharSequence ¤¤name = "Thunder";
/* 26 */   private static CharSequence ¤¤desc = "The amount of thunder.";
/*    */   
/* 28 */   private static double speed = 1.0D / TIME.secondsPerHour();
/*    */   
/*    */   static {
/* 31 */     D.ts(WeatherThunder.class);
/*    */   }
/*    */ 
/*    */   
/*    */   WeatherThunder() {
/* 36 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 42 */     setD(adjustTowards(getD(), ds * speed, this.target));
/*    */     
/* 44 */     this.flashIs = false;
/*    */     
/* 46 */     if (this.timer1 > 0.0F) {
/* 47 */       this.timer1 = (float)(this.timer1 - getD() * ds);
/* 48 */     } else if (this.timer2 > 0.0F) {
/* 49 */       this.timer2 = (float)(this.timer2 - ds);
/* 50 */       this.flashIs = true;
/*    */     } else {
/* 52 */       this.timer2 = RND.rFloat() * 0.2F;
/* 53 */       if (RND.rInt(4) == 0) {
/* 54 */         this.timer1 = RND.rFloat() * 4.0F;
/* 55 */         this.flash.setDir(RND.rInt(360));
/* 56 */         this.flash.setTilt(RND.rInt(10));
/* 57 */         this.flashI = 0.5D + (RND.rFloat() * 8.0F);
/*    */       } else {
/*    */         
/* 60 */         this.flashI /= 1.5D;
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     this.target = 0.0D;
/*    */   }
/*    */   
/*    */   public void setTarget(double target) {
/* 68 */     this.target = CLAMP.d(target, 0.0D, 1.0D);
/*    */   }
/*    */   
/*    */   public void makeSounds(double gain, float ds) {
/* 72 */     this.soundTimer -= ds * getD() / GAME.SPEED.speed();
/*    */     
/* 74 */     if (this.soundTimer < 0.0D) {
/* 75 */       this.soundTimer = (1.0F + RND.rFloat());
/* 76 */       ((SoundStream)(AUDIO.AMBI()).thunder.streams.rnd()).playOnce();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void apply(int x1, int x2, int y1, int y2) {
/* 81 */     if (this.flashIs && (S.get()).graphics.get() == 1) {
/* 82 */       this.flash.r(this.flashI).g(this.flashI).b(this.flashI);
/* 83 */       this.flash.register(x1, x2, y1, y2);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 89 */     setD(0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherThunder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */