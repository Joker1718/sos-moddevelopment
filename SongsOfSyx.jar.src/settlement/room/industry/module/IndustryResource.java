/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.data.DataOSimple;
/*    */ import util.data.INT_O;
/*    */ import util.statistics.HISTORY_INT;
/*    */ import util.statistics.HistoryInt;
/*    */ 
/*    */ public abstract class IndustryResource
/*    */   implements INDEXED, SAVABLE
/*    */ {
/*    */   public final RESOURCE resource;
/*    */   public final double rate;
/*    */   public final double AIRate;
/*    */   public final double AIRecovery;
/*    */   public final double rateSeconds;
/*    */   private final int index;
/* 27 */   protected final HistoryInt history = new HistoryInt(48, (TIMECYCLE)TIME.days(), false);
/*    */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> year;
/*    */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> yearPrev;
/*    */   public final DOUBLE_O.DOUBLE_OE<ROOM_IDATA_INSTANCE> day;
/*    */   public final INT_O.INT_OE<ROOM_IDATA_INSTANCE> dayPrev;
/*    */   
/*    */   public IndustryResource(DataOSimple<ROOM_IDATA_INSTANCE> data, int li, RESOURCE res, double rate, double AIRate, double AIRecovery) {
/* 34 */     this.resource = res;
/* 35 */     this.rate = rate;
/* 36 */     this.AIRate = AIRate;
/* 37 */     this.AIRecovery = AIRecovery;
/* 38 */     this.rateSeconds = Humanoid.WORK_PER_DAYI * rate / TIME.secondsPerDay();
/* 39 */     this.index = li;
/* 40 */     data.getClass(); this.year = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataInt(data);
/* 41 */     data.getClass(); this.yearPrev = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataInt(data);
/* 42 */     data.getClass(); this.day = (DOUBLE_O.DOUBLE_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataFloat(data);
/* 43 */     data.getClass(); this.dayPrev = (INT_O.INT_OE<ROOM_IDATA_INSTANCE>)new DataOSimple.DataInt(data);
/*    */   }
/*    */   
/*    */   public HISTORY_INT history() {
/* 47 */     return (HISTORY_INT)this.history;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 52 */     this.history.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 57 */     this.history.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 62 */     this.history.clear();
/*    */   }
/*    */   
/*    */   public int inc(ROOM_IDATA_INSTANCE r, double amount) {
/* 66 */     return inc(r, amount, true);
/*    */   }
/*    */   
/*    */   public abstract int inc(ROOM_IDATA_INSTANCE paramROOM_IDATA_INSTANCE, double paramDouble, boolean paramBoolean);
/*    */   
/*    */   public int work(Humanoid skill, ROOM_IDATA_INSTANCE r, double workSeconds) {
/* 72 */     double e = getEffort(skill, r, workSeconds);
/* 73 */     int a = inc(r, e);
/* 74 */     return a;
/*    */   }
/*    */   
/*    */   public int incDay(ROOM_IDATA_INSTANCE r) {
/* 78 */     return inc(r, this.rateSeconds);
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract double getEffort(Humanoid paramHumanoid, ROOM_IDATA_INSTANCE paramROOM_IDATA_INSTANCE, double paramDouble);
/*    */ 
/*    */   
/*    */   public int index() {
/* 86 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\IndustryResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */