/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import world.army.AD;
/*    */ import world.region.RD;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 46 */     GFORMAT.i(text, AD.conscripts().total(null).get(f.get()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 52 */     for (Race r : RACES.all()) {
/* 53 */       b.add((SPRITE)(r.appearance()).icon);
/* 54 */       b.textLL(r.info.names);
/* 55 */       b.tab(6);
/* 56 */       b.add((SPRITE)GFORMAT.i(b.text(), AD.conscripts().total(r).get(f.get())));
/* 57 */       b.text((CharSequence)b.text().add('(').add(RD.MILITARY().conscripts(r, (Faction)f.get())).add(')'));
/* 58 */       b.NL();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Realm$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */