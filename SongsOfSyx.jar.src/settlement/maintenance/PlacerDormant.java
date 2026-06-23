/*     */ package settlement.maintenance;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ final class PlacerDormant
/*     */   extends PlacableMulti
/*     */ {
/*  18 */   private static CharSequence ¤¤name = "¤Enable maintenance";
/*  19 */   private static CharSequence ¤¤nameAnti = "¤Disable maintenance";
/*  20 */   private static CharSequence ¤¤desc = "¤Enables maintenance performed by janitors in on area.";
/*  21 */   private static CharSequence ¤¤descAnti = "¤Disables maintenance performed by janitors on an area.";
/*     */   static {
/*  23 */     D.ts(PlacerDormant.class);
/*     */   }
/*     */   private SPRITE icon;
/*     */   public final PlacableMulti undo;
/*     */   
/*     */   public PlacerDormant() {
/*  29 */     super(¤¤name, ¤¤desc, null);
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
/*  73 */     this.undo = new PlacableMulti(¤¤nameAnti, ¤¤descAnti, null)
/*     */       {
/*     */         private SPRITE icon;
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  79 */           if (!(SETT.MAINTENANCE()).disabled.is(tx, ty))
/*  80 */             return null; 
/*  81 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  86 */           (SETT.MAINTENANCE()).disabled.set(tx, ty, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/*  91 */           if (this.icon == null)
/*  92 */             this.icon = (SPRITE)(SETT.ROOMS()).JANITOR.icon.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 1); 
/*  93 */           return this.icon;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/*  98 */           (SETT.OVERLAY()).MAINTENANCE.add();
/*  99 */           super.updateRegardless(window, selected);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 105 */           Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/* 106 */           if (r != null && r.degrader(fromX, fromY) != null && r.isSame(fromX, fromY, toX, toY))
/* 107 */             return true; 
/* 108 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 113 */           return (PLACABLE)PlacerDormant.this;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */     if ((SETT.MAINTENANCE()).disabled.is(tx, ty))
/*     */       return null; 
/*     */     return E;
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */     (SETT.MAINTENANCE()).disabled.set(tx, ty, false);
/*     */   }
/*     */   
/*     */   public PLACABLE getUndo() {
/*     */     return (PLACABLE)this.undo;
/*     */   }
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*     */     Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/*     */     if (r != null && r.degrader(fromX, fromY) != null && r.isSame(fromX, fromY, toX, toY))
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/*     */     (SETT.OVERLAY()).MAINTENANCE.add();
/*     */     super.updateRegardless(window, selected);
/*     */   }
/*     */   
/*     */   public SPRITE getIcon() {
/*     */     if (this.icon == null)
/*     */       this.icon = (SPRITE)(SETT.ROOMS()).JANITOR.icon.twin((SPRITE)(UI.icons()).s.cog, DIR.NE, 1); 
/*     */     return this.icon;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\PlacerDormant.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */