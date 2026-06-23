/*     */ package settlement.weather;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.sett.IDebugPanelSett;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RainEvent
/*     */ {
/*     */   private double downfall;
/*     */   private double time;
/*     */   private double thunder;
/*     */   private double cloud;
/*     */   private double timeToNext;
/*     */   private double droughtNext;
/*     */   private double droughtLength;
/*     */   final SAVABLE saver;
/*     */   
/*     */   RainEvent() {
/*  98 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 102 */           file.d(RainEvent.this.downfall);
/* 103 */           file.d(RainEvent.this.time);
/* 104 */           file.d(RainEvent.this.thunder);
/* 105 */           file.d(RainEvent.this.cloud);
/* 106 */           file.d(RainEvent.this.timeToNext);
/* 107 */           file.d(RainEvent.this.droughtNext);
/* 108 */           file.d(RainEvent.this.droughtLength);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 114 */           RainEvent.this.downfall = file.d();
/* 115 */           RainEvent.this.time = file.d();
/* 116 */           RainEvent.this.thunder = file.d();
/* 117 */           RainEvent.this.cloud = file.d();
/* 118 */           RainEvent.this.timeToNext = file.d();
/* 119 */           RainEvent.this.droughtNext = file.d();
/* 120 */           RainEvent.this.droughtLength = file.d();
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 125 */           RainEvent.this.time = 0.0D;
/* 126 */           RainEvent.this.setNextRain();
/* 127 */           RainEvent.this.setNextDrought(5);
/* 128 */           RainEvent.this.timeToNext /= 2.0D;
/*     */         }
/*     */       };
/*     */     this.saver.clear();
/*     */     IDebugPanelSett.add("WEATHER DROUGHT", new ACTION() {
/*     */           public void exe() {
/*     */             RainEvent.this.droughtNext = 0.0D;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   void rain(double size) {
/*     */     this.downfall = CLAMP.d(size + RND.rFloat(), 0.1D, 1.0D);
/*     */     this.time = TIME.secondsPerHour() * (0.5D + (RND.rFloat() * 4.0F));
/*     */     if (this.time * this.downfall < TIME.secondsPerHour() * 0.7D)
/*     */       this.time = 0.7D * TIME.secondsPerHour() / this.downfall; 
/*     */     this.cloud = 0.5D + RND.rFloat() * 0.5D;
/*     */     this.thunder = 0.0D;
/*     */     double wind = RND.rFloat();
/*     */     if ((SETT.WEATHER()).temp.heat() > 0.0D && RND.rBoolean()) {
/*     */       wind += RND.rFloat();
/*     */       this.thunder = RND.rFloat();
/*     */       this.cloud += 0.5D;
/*     */     } 
/*     */     (SETT.WEATHER()).wind.setDayTarget(wind);
/*     */   }
/*     */   
/*     */   void update(double ds) {
/*     */     SWEATHER w = SETT.WEATHER();
/*     */     this.droughtNext -= ds * ((SETT.ENV().climate()).tempCold + (SETT.ENV().climate()).tempWarm) * 0.5D;
/*     */     if (this.time > 0.0D) {
/*     */       this.time -= ds;
/*     */       w.rain.setTarget(this.downfall);
/*     */       w.clouds.setTarget(this.cloud);
/*     */       w.thunder.setTarget(this.thunder);
/*     */     } else if (this.droughtNext < 0.0D) {
/*     */       if (w.moisture.growthValue() < 1.0D) {
/*     */         this.droughtLength -= ds;
/*     */         if (this.droughtLength < 0.0D) {
/*     */           setNextDrought(1);
/*     */           setNextRain();
/*     */           rain(RND.rFloat());
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       this.timeToNext -= ds;
/*     */       if (this.timeToNext < 0.0D) {
/*     */         setNextRain();
/*     */         rain(RND.rFloat());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setNextRain() {
/*     */     this.timeToNext = (0.25D + RND.rFloat() * 2.7D) * TIME.secondsPerDay();
/*     */   }
/*     */   
/*     */   private void setNextDrought(int cooloffYears) {
/*     */     this.droughtNext = ((cooloffYears + RND.rFloat() * 10.0F) * TIME.secondsPerDay()) * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     this.droughtLength = (0.25D + (4.0F * RND.rFloat())) * TIME.secondsPerDay();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\RainEvent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */