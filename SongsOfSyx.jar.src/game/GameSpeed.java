/*     */ package game;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GameSpeed
/*     */ {
/*     */   private boolean tmpPaused;
/*     */   private double speed;
/*     */   private double prevSpeed;
/*     */   private double actualSpeed;
/*     */   private double actualSpeedI;
/*     */   private boolean updateOnce;
/*  19 */   public final int speed0 = 0;
/*  20 */   public final double speed05 = 0.25D;
/*  21 */   public final int speed1 = 1;
/*  22 */   public final int speed2 = 5;
/*  23 */   public final int speed3 = 25;
/*  24 */   public final int speed4 = 250;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double update(double slowTheFuckDown) {
/*  31 */     if (this.tmpPaused) {
/*  32 */       return clearAndReturn(0.0D);
/*     */     }
/*  34 */     if (this.updateOnce) {
/*  35 */       return clearAndReturn(1.0D);
/*     */     }
/*  37 */     double s = this.speed;
/*  38 */     if (GAME.ARMIES().enemy().men() > 0) {
/*  39 */       s = CLAMP.d(s, 0.0D, 25.0D);
/*     */     }
/*  41 */     if (this.actualSpeed < s && slowTheFuckDown < 1.0D) {
/*  42 */       this.actualSpeed++;
/*  43 */     } else if (slowTheFuckDown >= 1.0D) {
/*  44 */       this.actualSpeed /= 1.0D + (slowTheFuckDown - 1.0D) * 0.5D;
/*     */     } 
/*     */     
/*  47 */     this.actualSpeed = CLAMP.d(this.actualSpeed, 1.0D, s);
/*  48 */     if (this.actualSpeed > s)
/*  49 */       this.actualSpeed = s; 
/*  50 */     if (this.actualSpeed < 1.0D && s >= 1.0D) {
/*  51 */       this.actualSpeed = 1.0D;
/*     */     }
/*  53 */     this.actualSpeedI = 1.0D / CLAMP.d(this.actualSpeed, 1.0D, 1000.0D);
/*     */     
/*  55 */     return clearAndReturn(this.actualSpeed);
/*     */   }
/*     */ 
/*     */   
/*     */   private double clearAndReturn(double i) {
/*  60 */     this.tmpPaused = false;
/*  61 */     this.updateOnce = false;
/*  62 */     return i;
/*     */   }
/*     */   
/*     */   public boolean isPaused() {
/*  66 */     return !(this.speed != 0.0D && !this.tmpPaused);
/*     */   }
/*     */   
/*     */   public double speedTarget() {
/*  70 */     return this.tmpPaused ? 0.0D : this.speed;
/*     */   }
/*     */   
/*     */   public void updateOnce() {
/*  74 */     this.updateOnce = true;
/*     */   }
/*     */   
/*     */   public void tmpPause() {
/*  78 */     this.tmpPaused = true;
/*     */   }
/*     */   
/*     */   public void togglePause() {
/*  82 */     if (this.speed == 0.0D) {
/*  83 */       if (this.prevSpeed == 0.0D)
/*  84 */         this.prevSpeed = 1.0D; 
/*  85 */       this.speed = this.prevSpeed;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  90 */       this.prevSpeed = this.speed;
/*  91 */       this.speed = 0.0D;
/*     */     } 
/*  93 */     this.actualSpeed = this.speed;
/*  94 */     this.actualSpeedI = 1.0D / CLAMP.d(this.actualSpeed, 1.0D, 1000.0D);
/*     */   }
/*     */   
/*     */   public double speed() {
/*  98 */     return this.actualSpeed;
/*     */   }
/*     */   
/*     */   public double speedI() {
/* 102 */     return this.actualSpeedI;
/*     */   }
/*     */   
/*     */   public void speedSet(double speed) {
/* 106 */     this.prevSpeed = this.speed;
/* 107 */     this.speed = speed;
/* 108 */     this.actualSpeed = speed;
/* 109 */     this.actualSpeedI = 1.0D / CLAMP.d(this.actualSpeed, 1.0D, 1000.0D);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 113 */     file.d(this.speed);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 117 */     this.prevSpeed = file.d();
/* 118 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 123 */     this.speed = 0.0D;
/* 124 */     this.actualSpeed = 0.0D;
/* 125 */     this.tmpPaused = false;
/* 126 */     this.updateOnce = false;
/*     */   }
/*     */   
/*     */   public void poll() {
/* 130 */     if ((KEYS.MAIN()).PAUSE.consumeClick()) {
/* 131 */       togglePause();
/*     */     }
/* 133 */     if ((KEYS.MAIN()).SPEED1.consumeClick())
/* 134 */       if (this.speed == 1.0D) {
/* 135 */         speedSet(0.25D);
/*     */       } else {
/* 137 */         speedSet(1.0D);
/*     */       }  
/* 139 */     if ((KEYS.MAIN()).SPEED2.consumeClick()) {
/* 140 */       speedSet(5.0D);
/*     */     }
/* 142 */     if ((KEYS.MAIN()).SPEED3.consumeClick())
/* 143 */       if (this.speed == 25.0D) {
/* 144 */         speedSet(250.0D);
/*     */       } else {
/* 146 */         speedSet(25.0D);
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\GameSpeed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */