/*     */ package view.world.ui.panels;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import util.data.GETTER;
/*     */ import view.main.VIEW;
/*     */ import view.world.ui.WorldHoverer;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.caravan.Shipment;
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
/*     */ class Row
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final GETTER<Integer> g;
/*     */   
/*     */   Row(GETTER<Integer> g) {
/*  61 */     this.body.setDim(300.0D, 32.0D);
/*  62 */     this.g = g;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  67 */     if (((Integer)this.g.get()).intValue() >= UICaravanList.this.all().size())
/*     */       return; 
/*  69 */     Shipment s = (Shipment)UICaravanList.this.all().get(((Integer)this.g.get()).intValue());
/*  70 */     Icon icon = (SPRITES.icons()).m.urn;
/*  71 */     if (s.type() == TRADE_TYPE.spoils) {
/*  72 */       icon = (SPRITES.icons()).m.shield;
/*  73 */     } else if (s.type() == TRADE_TYPE.tax) {
/*  74 */       icon = (SPRITES.icons()).m.raw_materials;
/*  75 */     }  icon.renderCY(r, 10, body().cY());
/*     */     
/*  77 */     int m = 0;
/*  78 */     int x1 = body().x1() + 64;
/*  79 */     for (TRADABLE res : TR.ALL()) {
/*  80 */       if (m > 12)
/*     */         break; 
/*  82 */       if (s.loadGet(res) > 0) {
/*  83 */         m++;
/*  84 */         res.icon().renderCY(r, x1, body().cY());
/*  85 */         x1 += 24;
/*  86 */         if (m > 12) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/*  98 */     if (super.hover(mCoo)) {
/*  99 */       if (((Integer)this.g.get()).intValue() >= UICaravanList.this.all().size())
/* 100 */         return true; 
/* 101 */       Shipment s = (Shipment)UICaravanList.this.all().get(((Integer)this.g.get()).intValue());
/* 102 */       WORLD.OVERLAY().hoverEntity((WEntity)s);
/* 103 */       (VIEW.world()).window.centererTile.set(s.ctx(), s.cty());
/* 104 */       return true;
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 111 */     if (((Integer)this.g.get()).intValue() >= UICaravanList.this.all().size()) {
/*     */       return;
/*     */     }
/* 114 */     Shipment s = (Shipment)UICaravanList.this.all().get(((Integer)this.g.get()).intValue());
/* 115 */     WorldHoverer.hover(text, (WEntity)s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\panels\UICaravanList$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */