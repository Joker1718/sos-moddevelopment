/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.main.SETT;
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
/* 78 */     super($anonymous0, $anonymous1);
/* 79 */     this.stat = new GStat()
/*    */       {
/*    */         public void update(GText text)
/*    */         {
/* 83 */           int am = s.placement.placer.structure.mountainWalls() * (SETT.JOBS()).clearss.caveFill.resAmount();
/* 84 */           GFORMAT.i(text, am);
/*    */         }
/*    */       };
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 89 */     if (s.placement.placer.structure.mountainWalls() == 0)
/*    */       return; 
/* 91 */     RESOURCES.STONE().icon().render(r, body().x1(), body().y1());
/* 92 */     this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 97 */     text.text((RESOURCES.STONE()).name);
/* 98 */     text.NL();
/* 99 */     text.text((SETT.JOBS()).clearss.caveFill.placer().name());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */