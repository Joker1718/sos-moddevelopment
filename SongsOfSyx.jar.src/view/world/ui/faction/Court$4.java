/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.type.TRAIT;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   null(GText $anonymous0) {
/* 108 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void update(GText text) {
/* 112 */     ArrayListGrower arrayListGrower = (((FactionNPC)f.get()).court().king().roy()).traits;
/* 113 */     for (int i = 0; i < arrayListGrower.size(); i++) {
/* 114 */       text.add(((TRAIT)arrayListGrower.get(i)).rTitle);
/* 115 */       if (i < arrayListGrower.size() - 1)
/* 116 */         text.add(',').s(); 
/*     */     } 
/* 118 */     text.setMaxWidth(600);
/* 119 */     text.setMultipleLines(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Court$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */