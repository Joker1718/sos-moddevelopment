/*    */ package view.sett.ui.room.prints;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.copy.SavedPrints;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.main.VIEW;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableSingle;
/*    */ import view.tool.ToolConfig;
/*    */ 
/*    */ class PlacerSave
/*    */   extends PlacableSingle
/*    */ {
/* 19 */   private static CharSequence ¤¤not = "¤A room that can be furnished must be selected.";
/*    */   
/*    */   static {
/* 22 */     D.ts(PlacerSave.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final UISavedPrints pp;
/*    */ 
/*    */   
/* 29 */   final ToolConfig config = new ToolConfig()
/*    */     {
/*    */       public void addUI(LISTE<RENDEROBJ> uis) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void activateAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void update(boolean UIHovered) {
/* 43 */         if (!(VIEW.s()).panels.added(PlacerSave.this.pp)) {
/* 44 */           (VIEW.s()).tools.place(null, null, false);
/*    */         }
/*    */       }
/*    */       
/*    */       public boolean back() {
/* 49 */         if (PlacerSave.this.pp.placing != null) {
/* 50 */           PlacerSave.this.pp.placing = null;
/* 51 */           return false;
/*    */         } 
/* 53 */         (VIEW.s()).panels.remove(PlacerSave.this.pp);
/* 54 */         return true;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   PlacerSave(UISavedPrints panel) {
/* 60 */     super("");
/* 61 */     this.pp = panel;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 66 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 67 */     if (r == null)
/* 68 */       return PlacableMessages.¤¤ROOM_MUST; 
/* 69 */     if (!(r instanceof settlement.room.main.ROOMA)) {
/* 70 */       return ¤¤not;
/*    */     }
/* 72 */     if (!(SETT.ROOMS()).copy.prints.canAdd(r))
/* 73 */       return ¤¤not; 
/* 74 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void placeFirst(int tx, int ty) {
/* 79 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 80 */     SavedPrints.SavedPrint p = (SETT.ROOMS()).copy.prints.push(r, tx, ty);
/* 81 */     if (p != null) {
/* 82 */       this.pp.set(p);
/*    */     }
/*    */   }
/*    */   
/*    */   public SPRITE getIcon() {
/* 87 */     return (SPRITE)(SPRITES.icons()).m.crossair;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 92 */     return (isPlacable(toX, toY) == null && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\PlacerSave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */