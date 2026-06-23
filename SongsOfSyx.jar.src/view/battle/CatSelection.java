/*    */ package view.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*    */ import snake2d.util.sets.ArrayListResize;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class CatSelection
/*    */ {
/* 12 */   private final ArrayListResize<ArtilleryInstance> all = new ArrayListResize(128);
/* 13 */   private final ArrayListResize<ArtilleryInstance> selection = new ArrayListResize(128);
/* 14 */   private int upI = -1;
/*    */   
/*    */   public LIST<ArtilleryInstance> all() {
/* 17 */     if (this.upI != GAME.updateI()) {
/* 18 */       this.all.clearSoft();
/* 19 */       this.selection.clearSoft();
/* 20 */       this.upI = GAME.updateI();
/* 21 */       for (ROOM_ARTILLERY cat : (SETT.ROOMS()).ARTILLERY) {
/* 22 */         for (int i = 0; i < cat.instancesSize(); i++) {
/* 23 */           ArtilleryInstance ins = (ArtilleryInstance)cat.getInstance(i);
/* 24 */           this.all.add(ins);
/* 25 */           if (ins.selected)
/* 26 */             this.selection.add(ins); 
/*    */         } 
/*    */       } 
/*    */     } 
/* 30 */     return (LIST<ArtilleryInstance>)this.all;
/*    */   }
/*    */   
/*    */   public void select(ArtilleryInstance s) {
/* 34 */     if (!s.selected) {
/* 35 */       s.selected = true;
/* 36 */       this.selection.add(s);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void deSelect(ArtilleryInstance s) {
/* 41 */     if (s.selected) {
/* 42 */       s.selected = false;
/* 43 */       this.selection.remove(s);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void clear() {
/* 48 */     for (ArtilleryInstance ins : all()) {
/* 49 */       ins.selected = false;
/* 50 */       ins.hovered = false;
/*    */     } 
/* 52 */     this.selection.clearSoft();
/*    */   }
/*    */   
/*    */   public LIST<ArtilleryInstance> selection() {
/* 56 */     all();
/* 57 */     return (LIST<ArtilleryInstance>)this.selection;
/*    */   }
/*    */   
/*    */   public boolean isClear() {
/* 61 */     return (this.selection.size() == 0);
/*    */   }
/*    */   
/*    */   public void toggle(ArtilleryInstance f) {
/* 65 */     if (f.selected) {
/* 66 */       deSelect(f);
/*    */     } else {
/* 68 */       select(f);
/*    */     } 
/*    */   }
/*    */   public void clearHover() {
/* 72 */     for (ArtilleryInstance ins : all())
/* 73 */       ins.hovered = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\CatSelection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */