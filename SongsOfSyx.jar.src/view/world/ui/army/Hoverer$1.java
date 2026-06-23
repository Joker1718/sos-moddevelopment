/*    */ package view.world.ui.army;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.Dic;
/*    */ import world.entity.army.WArmy;
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
/* 39 */     if (((WArmy)Hoverer.this.a.get()).faction() != null) {
/* 40 */       text.color((COLOR)((WArmy)Hoverer.this.a.get()).faction().banner().colorBGBright());
/* 41 */       text.add((CharSequence)(((WArmy)Hoverer.this.a.get()).faction()).name);
/*    */     } else {
/* 43 */       text.color(COLOR.WHITE85);
/* 44 */       if ((GAME.raiders()).current.army() == Hoverer.this.a.get()) {
/* 45 */         text.add(((GAME.raiders()).current.current()).name);
/*    */       } else {
/* 47 */         text.add(Dic.¤¤Rebels);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\Hoverer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */