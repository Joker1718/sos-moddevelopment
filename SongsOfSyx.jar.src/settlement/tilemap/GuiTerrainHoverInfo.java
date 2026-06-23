/*    */ package settlement.tilemap;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.D;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GuiTerrainHoverInfo
/*    */ {
/* 18 */   private static CharSequence ¤¤Degrade = "¤Degrade:";
/* 19 */   private static CharSequence ¤¤Strength = "¤Strength:";
/* 20 */   private static CharSequence ¤¤Border = "¤This is a static entry point to your city. Keep this clear and reachable.";
/*    */   
/*    */   static {
/* 23 */     D.ts(GuiTerrainHoverInfo.class);
/*    */   }
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
/*    */   public static void add(GBox box, int tx, int ty) {
/* 36 */     (SETT.TILE_MAP()).ground.hover((GUI_BOX)box, tx, ty);
/*    */     
/* 38 */     if (!(SETT.TERRAIN()).NADA.is(tx, ty)) {
/* 39 */       SETT.TERRAIN().get(tx, ty).hoverInfo(box, tx, ty);
/* 40 */       double st = (GAME.ARMIES()).map.strength.get(tx, ty) / 64.0D;
/* 41 */       if (st > 0.0D) {
/* 42 */         box.NL();
/* 43 */         box.textL(¤¤Strength);
/* 44 */         box.add((SPRITE)GFORMAT.f0(box.text(), st));
/*    */       } 
/* 46 */       box.sep();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 51 */     if ((SETT.FLOOR()).getter.is(tx, ty)) {
/* 52 */       GText t = box.text();
/* 53 */       t.lablify().add(((Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty)).name());
/* 54 */       box.add((SPRITE)t);
/* 55 */       box.add((SPRITE)box.text().add(¤¤Degrade));
/* 56 */       box.add((SPRITE)GFORMAT.percInv(box.text(), (SETT.FLOOR()).degrade.get(tx, ty)));
/*    */       
/* 58 */       if ((SETT.MAINTENANCE()).isser.is(tx, ty)) {
/* 59 */         box.add((SPRITE)(SPRITES.icons()).s.hammer);
/*    */       }
/* 61 */       box.sep();
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 67 */     if ((SETT.ENTRY()).points.map.is(tx, ty)) {
/* 68 */       box.add((SPRITE)box.text().normalify2().add(¤¤Border));
/* 69 */       box.sep();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\GuiTerrainHoverInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */