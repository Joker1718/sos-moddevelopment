/*     */ package view.world.generator;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimple;
/*     */ import world.WORLD;
/*     */ import world.map.landmark.WorldLandmark;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.regions.Region;
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
/*     */ class null
/*     */   extends PlacableSimple
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  43 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/*  60 */     return (LIST<CLICKABLE>)butts;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int cx, int cy, boolean isPlacable) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAction(int cx, int cy) {
/*  70 */     if (start.x() >= 0) {
/*  71 */       int tx = cx / 64;
/*  72 */       int ty = cy / 64;
/*  73 */       (WORLD.OVERLAY()).path.add(start.x(), start.y(), tx, ty, WRegFinder.Treaty.DUMMY);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     super.renderAction(cx, cy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int cx, int cy) {
/*  84 */     int tx = cx / 64;
/*  85 */     int ty = cy / 64;
/*  86 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */     
/*  88 */     (WORLD.OVERLAY()).landmarks.add();
/*     */     
/*  90 */     if (reg != null) {
/*  91 */       WORLD.OVERLAY().hoverBox(reg);
/*     */       
/*  93 */       (WORLD.OVERLAY()).regionOutline.add(reg);
/*  94 */       if ((WORLD.REGIONS()).isCentre.is(tx, ty)) {
/*  95 */         (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)b);
/*     */       
/*     */       }
/*     */     }
/*  99 */     else if ((WORLD.LANDMARKS()).setter.get(tx, ty) != null) {
/* 100 */       WorldLandmark m = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(tx, ty);
/* 101 */       b.title((CharSequence)m.name);
/* 102 */       b.text((CharSequence)m.description);
/* 103 */       (WORLD.OVERLAY()).landmarks.hover((WorldLandmark)(WORLD.LANDMARKS()).setter.get(tx, ty));
/*     */     } 
/*     */     
/* 106 */     b.NL(8);
/* 107 */     b.add((SPRITE)b.text().add(tx).add(':').add(ty));
/* 108 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageFinish$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */