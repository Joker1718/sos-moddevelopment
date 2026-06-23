/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import util.data.INT;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ public abstract class RoomTally
/*    */ {
/*    */   public RoomTally() {
/* 12 */     this.all = new ArrayListGrower();
/*    */   }
/*    */   private ArrayListGrower<TallyEntry> all;
/*    */   
/*    */   public class TallyEntry implements INT_O.INT_OE<RoomInstance> { public final CharSequence name;
/*    */     public final int index;
/* 18 */     private final INT.IntImp ptot = new INT.IntImp();
/* 19 */     public final INT total = (INT)this.ptot;
/*    */     
/*    */     public final TallyEntry tottot;
/*    */     
/*    */     TallyEntry(CharSequence name) {
/* 24 */       this(name, null);
/*    */     }
/*    */ 
/*    */     
/*    */     TallyEntry(CharSequence name, TallyEntry total) {
/* 29 */       this.index = RoomTally.this.all.add(this);
/* 30 */       this.name = name;
/* 31 */       this.tottot = total;
/*    */     }
/*    */ 
/*    */     
/*    */     public int min(RoomInstance t) {
/* 36 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public int max(RoomInstance t) {
/* 41 */       return Integer.MAX_VALUE;
/*    */     }
/*    */ 
/*    */     
/*    */     public int get(RoomInstance t) {
/* 46 */       return RoomTally.this.data(t)[this.index];
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(RoomInstance t, int amount) {
/* 51 */       int[] data = RoomTally.this.data(t);
/* 52 */       if (this.tottot != null)
/* 53 */         this.tottot.inc(t, -data[this.index]); 
/* 54 */       this.ptot.inc(-data[this.index]);
/* 55 */       data[this.index] = amount;
/* 56 */       if (this.tottot != null)
/* 57 */         this.tottot.inc(t, data[this.index]); 
/* 58 */       this.ptot.inc(data[this.index]);
/*    */     } }
/*    */ 
/*    */   
/*    */   public TallyEntry make(CharSequence name) {
/* 63 */     return new TallyEntry(name);
/*    */   }
/*    */ 
/*    */   
/*    */   public TallyEntry make(CharSequence name, TallyEntry tot) {
/* 68 */     return new TallyEntry(name, tot);
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract int[] data(RoomInstance paramRoomInstance);
/*    */   
/*    */   public int[] makeInstanceData() {
/* 75 */     return Alloc.ii(this.all.size());
/*    */   }
/*    */   
/*    */   public void clear() {
/* 79 */     for (TallyEntry e : this.all) {
/* 80 */       e.ptot.set(0);
/*    */     }
/*    */   }
/*    */   
/*    */   public void load(RoomInstance ins) {
/* 85 */     int[] dd = data(ins);
/* 86 */     for (int i = 0; i < this.all.size(); i++)
/* 87 */       ((TallyEntry)this.all.get(i)).ptot.inc(dd[i]); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */