/*    */ package view.world.panel;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.MButt;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ import world.WORLD;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ final class WorldHeatmaps extends GButt.ButtPanel {
/* 16 */   private WorldOverlays.OverlayTileNormal selected = null; private final GuiSection s;
/*    */   
/*    */   WorldHeatmaps() {
/* 19 */     super((SPRITE)(SPRITES.icons()).s.eye);
/* 20 */     this.s = new GuiSection();
/*    */     
/* 22 */     hoverInfoSet(Dic.¤¤Overlays);
/*    */ 
/*    */     
/* 25 */     GButt.Checkbox c = new GButt.Checkbox(Dic.¤¤name)
/*    */       {
/*    */         protected void clickA()
/*    */         {
/* 29 */           (WORLD.OVERLAY()).regNames.active.toggle();
/*    */         }
/*    */ 
/*    */         
/*    */         protected void renAction() {
/* 34 */           selectedSet((WORLD.OVERLAY()).regNames.active.is());
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 39 */     this.s.addDown(0, (RENDEROBJ)c);
/*    */ 
/*    */     
/* 42 */     for (WorldOverlays.OverlayTileNormal o : (WORLD.OVERLAY()).togglable) {
/* 43 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel(o.info.name)
/*    */         {
/*    */           protected void clickA()
/*    */           {
/* 47 */             if (WorldHeatmaps.this.selected == o) {
/* 48 */               WorldHeatmaps.this.selected = null;
/*    */             } else {
/* 50 */               WorldHeatmaps.this.selected = o;
/*    */             } 
/*    */           }
/*    */           
/*    */           protected void renAction() {
/* 55 */             selectedSet((WorldHeatmaps.this.selected == o));
/*    */           }
/*    */         };
/*    */ 
/*    */       
/* 60 */       buttPanel.hoverSet(o.info);
/* 61 */       buttPanel.body().setWidth(200.0D);
/* 62 */       this.s.addDown(0, (RENDEROBJ)buttPanel);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 70 */     (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 75 */     if (hoveredIs() && MButt.RIGHT.consumeClick()) {
/* 76 */       this.selected = null;
/*    */     }
/*    */     
/* 79 */     if (this.selected != null) {
/* 80 */       this.selected.add();
/*    */     }
/*    */     
/* 83 */     selectedSet((this.selected != null));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\WorldHeatmaps.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */