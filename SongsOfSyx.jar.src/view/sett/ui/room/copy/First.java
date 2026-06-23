/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.Dic;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ final class First
/*    */   extends PlacableMulti
/*    */ {
/*    */   private final Source source;
/*    */   
/*    */   public First(Source source) {
/* 19 */     super(Dic.¤¤Copy, "", (SPRITE)(SPRITES.icons()).m.expand);
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
/* 53 */     this.undo = (PLACABLE)new PlacableMulti(Dic.¤¤Undo, "", (SPRITE)(SPRITES.icons()).m.cancel)
/*    */       {
/*    */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*    */         {
/* 57 */           First.this.source.set(tx, ty, false);
/*    */         }
/*    */ 
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 62 */           if (First.this.source.is(tx, ty))
/* 63 */             return null; 
/* 64 */           return E;
/*    */         }
/*    */         
/*    */         public boolean expandsTo(int fromX, int fromY, int toX, int toY)
/*    */         {
/* 69 */           return (First.this.source.is(fromX, fromY) && (SETT.ROOMS()).copy.copier.canCopy(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*    */         }
/*    */       };
/*    */     this.source = source;
/*    */   } private final PLACABLE undo;
/*    */   public PLACABLE getUndo() {
/* 75 */     return this.undo;
/*    */   }
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */     if (!SETT.IN_BOUNDS(tx, ty))
/*    */       return E; 
/*    */     if (Jobs.get(tx, ty) == null && !(SETT.ROOMS()).copy.copier.canCopy(tx, ty))
/*    */       return E; 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */     this.source.set(tx, ty, true);
/*    */   }
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*    */     return ((SETT.ROOMS()).copy.copier.canCopy(fromX, fromY) && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*    */   }
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*    */     if (this.source.is(tx, ty))
/*    */       return; 
/*    */     if (isPlacable) {
/*    */       super.renderPlaceHolder(r, mask, x, y, tx, ty, area, type, isPlacable, areaIsPlacable);
/*    */     } else {
/*    */       (SPRITES.cons()).BIG.dashed_hollow.render(r, mask, x, y);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\First.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */