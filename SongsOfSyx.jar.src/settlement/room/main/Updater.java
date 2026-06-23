/*    */ package settlement.room.main;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ class Updater
/*    */   implements SAVABLE
/*    */ {
/* 14 */   private int dayCurrent = TIME.days().bitsSinceStart();
/*    */   private boolean day;
/* 16 */   private final double UPDATE_INTERVAL = 64.0D;
/* 17 */   private final double UPDATE_INTERVALI = 0.015625D;
/* 18 */   private double acc = 0.0D;
/* 19 */   private int ii = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   Updater(LIST<RoomBlueprintIns<?>> all) {}
/*    */ 
/*    */   
/*    */   public void update(double ds) {
/* 27 */     int max = (SETT.ROOMS()).map.max();
/* 28 */     double n = this.acc += ds * max * 0.015625D;
/* 29 */     int am = (int)n;
/* 30 */     this.acc = n - am;
/*    */ 
/*    */ 
/*    */     
/* 34 */     int i = 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 60 */     file.bool(this.day);
/* 61 */     file.i(this.dayCurrent);
/* 62 */     file.i(this.ii);
/* 63 */     file.d(this.acc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 70 */     this.day = file.bool();
/* 71 */     this.dayCurrent = file.i();
/* 72 */     this.ii = file.i();
/* 73 */     this.acc = file.d();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 79 */     this.dayCurrent = TIME.days().bitsSinceStart();
/* 80 */     this.day = false;
/* 81 */     this.ii = 0;
/* 82 */     this.acc = 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */