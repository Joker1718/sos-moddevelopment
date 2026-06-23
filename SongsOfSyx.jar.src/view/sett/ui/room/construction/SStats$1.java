/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   final GStat stat;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 48 */     super($anonymous0, $anonymous1);
/* 49 */     this.stat = new GStat()
/*    */       {
/*    */         public void update(GText text)
/*    */         {
/* 53 */           int am = s.placement.placer.structure.roofs() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/* 54 */           am += s.placement.placer.structure.walls() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/* 55 */           GFORMAT.i(text, am);
/*    */         }
/*    */       };
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 60 */     if (((TBuilding)s.placement.placer.structure.get()).structure.resource != null) {
/* 61 */       ((TBuilding)s.placement.placer.structure.get()).structure.resource.icon().render(r, body().x1(), body().y1());
/* 62 */       this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 70 */     if (((TBuilding)s.placement.placer.structure.get()).structure.resource != null) {
/* 71 */       text.text(((TBuilding)s.placement.placer.structure.get()).structure.resource.name);
/* 72 */       text.NL();
/* 73 */       text.text(((TBuilding)s.placement.placer.structure.get()).structure.nameCeiling);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */