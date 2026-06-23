/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*    */ import settlement.room.main.placement.PLACEMENT;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ final class State
/*    */ {
/* 13 */   final int[] item = Alloc.ii((SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS);
/*    */   
/* 15 */   final PLACEMENT placement = (SETT.ROOMS()).placement;
/*    */   RoomBlueprintImp b;
/*    */   boolean refurnishing;
/* 18 */   final Config config = new Config(this);
/* 19 */   private int itemI = 0;
/*    */   
/*    */   RoomCategorySub collection;
/*    */   
/*    */   FurnisherItemGroup problemGroup;
/*    */   boolean problemneedDoor;
/*    */   boolean problemneedArea;
/*    */   double problemTimer;
/*    */   
/*    */   public void setItem(int itI) {
/* 29 */     this.itemI = CLAMP.i(itI, 0, this.b.constructor().pgroups().size());
/* 30 */     this.item[this.b.index()] = this.itemI;
/*    */   }
/*    */   
/*    */   public int item() {
/* 34 */     return this.itemI;
/*    */   }
/*    */   
/*    */   public void init(RoomBlueprintImp b2, boolean refurnishing) {
/* 38 */     this.collection = null;
/*    */     
/* 40 */     this.config.build = true;
/* 41 */     this.b = b2;
/* 42 */     if (b2.constructor().usesArea()) {
/* 43 */       setItem(0);
/*    */     } else {
/* 45 */       setItem(this.item[b2.index()]);
/* 46 */     }  this.refurnishing = refurnishing;
/*    */     
/* 48 */     this.problemGroup = null;
/* 49 */     this.problemneedDoor = false;
/* 50 */     this.problemneedArea = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(RoomBlueprintImp b2, RoomCategorySub collection) {
/* 60 */     init(b2, false);
/* 61 */     this.collection = collection;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\State.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */