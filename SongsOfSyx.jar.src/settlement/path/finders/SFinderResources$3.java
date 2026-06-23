/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PlacableSimpleTile;
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
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   RBIT.RBITImp bits;
/*     */   LIST<CLICKABLE> li;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/*  83 */     super($anonymous0);
/*     */     
/*  85 */     this.bits = new RBIT.RBITImp();
/*     */ 
/*     */     
/*  88 */     GuiSection s = new GuiSection();
/*  89 */     for (RESOURCE r : RESOURCES.ALL()) {
/*  90 */       s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)r.icon())
/*     */           {
/*     */             protected void clickA() {
/*  93 */               SFinderResources.null.this.bits.toggle(r);
/*     */             }
/*     */             
/*     */             protected void renAction() {
/*  97 */               selectedSet(SFinderResources.null.this.bits.has(r));
/*     */             }
/*  99 */           }r.index(), 10, 0, 0);
/*     */     } 
/* 101 */     this.li = (LIST<CLICKABLE>)new ArrayList(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 106 */     SPath p = new SPath();
/* 107 */     RESOURCE res = SFinderResources.this.find((RBIT)this.bits, (COORDINATE)new Coo(tx, ty), p, 250);
/*     */     
/* 109 */     if (res == null) {
/* 110 */       LOG.ln("nope");
/*     */     } else {
/* 112 */       LOG.ln("" + p.destX() + " " + p.destX());
/* 113 */       RESOURCE_TILE.GETTER.reserved(res, p.destX(), p.destY());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 124 */     return this.li;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResources$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */