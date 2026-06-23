/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.employment.RoomEquip;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
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
/*    */   extends UIPanelUtil.RoomRow
/*    */ {
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 54 */     super.hoverInfoGet(text);
/* 55 */     GBox b = (GBox)text;
/* 56 */     b.NL(8);
/*    */     
/* 58 */     b.textL(UIPanelWorkTools.¤¤level);
/* 59 */     b.add((SPRITE)GFORMAT.i(b.text(), work.target(bb.employment()).availableMax()));
/* 60 */     b.NL();
/* 61 */     if (work.target(bb.employment()).boost() != null) {
/* 62 */       work.target(bb.employment()).boost().hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*    */     }
/* 64 */     b.sep();
/*    */     
/* 66 */     b.textL(Dic.¤¤Boosts);
/* 67 */     b.NL();
/* 68 */     (work.boost(bb.employment())).booster.hover((GUI_BOX)b, work.targetI(bb.employment()) / (work.target(bb.employment()).max() * bb.employment().employed()));
/* 69 */     (work.boost(bb.employment())).booster.hoverSpan((GUI_BOX)b, work.targetI(bb.employment()) / (work.target(bb.employment()).max() * bb.employment().employed()));
/* 70 */     b.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelWorkTools$2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */