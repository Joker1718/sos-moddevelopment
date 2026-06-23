/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.room.infra.logistics.MoveJob;
/*    */ import settlement.room.main.job.StorageCrate;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ 
/*    */ final class Organiser
/*    */ {
/* 12 */   private Bitmap1D check = new Bitmap1D(RESOURCES.ALL().size(), false);
/* 13 */   private int[] amounts = Alloc.ii(RESOURCES.ALL().size());
/* 14 */   private int[] xs = Alloc.ii(RESOURCES.ALL().size());
/* 15 */   private int[] ys = Alloc.ii(RESOURCES.ALL().size());
/*    */ 
/*    */ 
/*    */   
/*    */   Organiser(ROOM_STOCKPILE b) {}
/*    */ 
/*    */   
/*    */   public MoveJob organise(StockpileInstance ins, int am) {
/* 23 */     this.check.clear();
/*    */     int i;
/* 25 */     for (i = 0; i < ins.crates.size(); i++) {
/* 26 */       ins.crates.set(i);
/* 27 */       StorageCrate storageCrate = ins.crate(ins.crates.get().x(), ins.crates.get().y());
/* 28 */       if (storageCrate != null && storageCrate.resource() != null && storageCrate.storageReservable() > 0) {
/* 29 */         int ri = storageCrate.resource().index();
/* 30 */         if (!this.check.get(ri) || storageCrate.storageReservable() < this.amounts[ri]) {
/* 31 */           this.check.set(ri, true);
/* 32 */           this.amounts[ri] = storageCrate.storageReservable();
/* 33 */           this.xs[ri] = storageCrate.x();
/* 34 */           this.ys[ri] = storageCrate.y();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 39 */     for (i = 0; i < ins.crates.size(); i++) {
/* 40 */       ins.crates.set(i);
/* 41 */       StorageCrate s = ins.crate(ins.crates.get().x(), ins.crates.get().y());
/* 42 */       if (s != null && s.resource() != null && this.check.get(s.resource().index()) && s.reservable() > 0) {
/* 43 */         int ri = s.resource().index();
/* 44 */         if (s.x() != this.xs[ri] || s.y() != this.ys[ri])
/*    */         {
/* 46 */           if (s.storageReservable() >= this.amounts[ri]) {
/*    */             
/* 48 */             MoveJob j = MoveJob.TMP;
/* 49 */             am = Math.min(am, s.reservable());
/* 50 */             am = Math.min(am, this.amounts[ri]);
/* 51 */             j.maxAm = am;
/* 52 */             j.res = s.resource();
/* 53 */             j.stored = true;
/* 54 */             j.prio = ins.prioritizing();
/* 55 */             j.source.set((COORDINATE)s);
/* 56 */             j.dest.set(this.xs[ri], this.ys[ri]);
/* 57 */             return j;
/*    */           }  } 
/*    */       } 
/*    */     } 
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Organiser.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */