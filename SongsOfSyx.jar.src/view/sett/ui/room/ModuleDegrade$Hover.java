/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.Stack;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */ final class Hover
/*    */   extends UIRoomModule
/*    */ {
/*    */   public void hover(GBox box, Room room, int rx, int ry) {
/* 70 */     if (room.degrader(rx, ry) != null) {
/* 71 */       box.text(Dic.¤¤Degrade);
/* 72 */       box.add((SPRITE)GFORMAT.percInv(box.text(), room.getDegrade(rx, ry)));
/* 73 */       box.add((SPRITE)(UI.icons()).s.hammer);
/* 74 */       box.add((SPRITE)GFORMAT.i(box.text(), room.degrader(rx, ry).jobs()));
/* 75 */       box.NL(2);
/* 76 */       if (!(room.constructor().blue()).reqs.passes(FACTIONS.player())) {
/* 77 */         box.error(ModuleDegrade.¤¤Lock);
/* 78 */       } else if (room.upgrade(rx, ry) > 0 && !room.constructor().blue().upgrades().requires(room.upgrade(rx, ry)).passes(FACTIONS.player())) {
/* 79 */         box.error(ModuleDegrade.¤¤Lock);
/* 80 */       }  box.NL(2);
/*    */     } 
/* 82 */     if (room.constructor() != null && room.constructor().needsIsolation()) {
/* 83 */       box.text((SETT.ROOMS()).isolation.info.name);
/* 84 */       box.add((SPRITE)GFORMAT.perc(box.text(), room.isolation(rx, ry)));
/* 85 */       box.NL(2);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 94 */     if (room.getDegrade(rx, ry) > 0.25D) {
/* 95 */       errors.add(Dic.¤¤Degrade);
/*    */     }
/* 97 */     if (room.constructor() != null && room.constructor().mustBeIndoors() && room.isolation(rx, ry) < 1.0D)
/* 98 */       warnings.add(ModuleDegrade.¤¤badIsolation); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleDegrade$Hover.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */