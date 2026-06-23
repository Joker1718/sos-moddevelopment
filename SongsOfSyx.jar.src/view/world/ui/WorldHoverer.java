/*    */ package view.world.ui;
/*    */ 
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ import world.entity.WEntity;
/*    */ import world.entity.army.WArmy;
/*    */ import world.entity.caravan.Shipment;
/*    */ import world.entity.haven.WHaven;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldHoverer
/*    */ {
/*    */   public static void hover(GUI_BOX box, WEntity e) {
/* 27 */     if (e instanceof WArmy) {
/* 28 */       (VIEW.world()).UI.armies.hover(box, (WArmy)e);
/* 29 */     } else if (e instanceof Shipment) {
/* 30 */       hover(box, (Shipment)e);
/* 31 */     } else if (e instanceof WHaven) {
/* 32 */       (VIEW.world()).UI.camps.hover(box, (WHaven)e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void hover(GUI_BOX box, Shipment e) {
/* 40 */     GBox b = (GBox)box;
/* 41 */     b.title(Dic.¤¤Caravan);
/* 42 */     b.textL((e.type()).name);
/* 43 */     b.NL(8);
/* 44 */     Region c = e.destination();
/* 45 */     if (c == null || c.faction() == null) {
/*    */       return;
/*    */     }
/* 48 */     GText t = b.text();
/* 49 */     t.color((COLOR)c.faction().banner().colorBG());
/* 50 */     t.add(Dic.¤¤BoundFor).insert(0, (CharSequence)c.info.name());
/* 51 */     box.add((SPRITE)t);
/* 52 */     box.NL(4);
/*    */     
/* 54 */     int i = 0;
/* 55 */     for (TRADABLE r : TR.ALL()) {
/* 56 */       if (e.loadGet(r) > 0) {
/* 57 */         box.add(r.icon());
/* 58 */         box.add((SPRITE)GFORMAT.i(b.text(), e.loadGet(r)));
/* 59 */         i++;
/* 60 */         if (i > 8) {
/* 61 */           i = 0;
/* 62 */           box.NL();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\WorldHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */