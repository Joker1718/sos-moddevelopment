/*    */ package world.map.buildings;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.subview.GameWindow;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableMulti;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ class Placer
/*    */   extends PlacableMulti
/*    */ {
/* 20 */   private static CharSequence ¤¤name = "village";
/*    */   
/* 22 */   private final PlacableMulti undo = new PlacableMulti(String.valueOf(Dic.¤¤remove) + ": " + String.valueOf(Dic.¤¤remove), "", (SPRITE)(UI.icons()).m.building.twin((SPRITE)(UI.icons()).m.anti))
/*    */     {
/*    */       public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*    */       {
/* 26 */         (WORLD.BUILDINGS()).village.set(tx, ty, false);
/*    */       }
/*    */ 
/*    */       
/*    */       public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 31 */         return (WORLD.BUILDINGS()).village.is(tx, ty) ? null : E;
/*    */       }
/*    */ 
/*    */       
/*    */       public void updateRegardless(GameWindow window, AREA selected) {
/* 36 */         (WORLD.BUILDINGS()).debugVisible = true;
/*    */       }
/*    */     };
/*    */   
/*    */   static {
/* 41 */     D.ts(Placer.class);
/*    */   }
/*    */   
/*    */   Placer() {
/* 45 */     super(¤¤name, "", (SPRITE)(UI.icons()).m.building);
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 50 */     int tile = tx + ty * WORLD.TWIDTH();
/* 51 */     (WORLD.BUILDINGS()).village.set(tile, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 58 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 59 */       return PlacableMessages.¤¤IN_MAP; 
/* 60 */     if ((WORLD.REGIONS()).isCentre.is(tx, ty))
/* 61 */       return PlacableMessages.¤¤BLOCKED; 
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateRegardless(GameWindow window, AREA selected) {
/* 67 */     (WORLD.BUILDINGS()).debugVisible = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 72 */     return (PLACABLE)this.undo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */