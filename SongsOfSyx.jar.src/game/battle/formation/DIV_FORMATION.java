/*    */ package game.battle.formation;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DIV_FORMATION
/*    */ {
/* 14 */   TIGHT(1.2D),
/* 15 */   LOOSE(1.75D);
/*    */   public static final LIST<DIV_FORMATION> all;
/*    */   
/*    */   static {
/* 19 */     all = (LIST<DIV_FORMATION>)new ArrayList((Object[])values());
/*    */   }
/*    */   private final double size;
/*    */   
/*    */   DIV_FORMATION(double size) {
/* 24 */     this.size = size;
/*    */   }
/*    */   
/*    */   public int size(DIV_SPEC div) {
/* 28 */     int am = 0;
/* 29 */     for (int i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 30 */       EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 31 */       if (div.equipI(b) > 0) {
/* 32 */         am = Math.max(b.formationAdd, am);
/*    */       }
/*    */     } 
/* 35 */     return (int)(((div.race()).physics.hitBoxsize() + am) * this.size);
/*    */   }
/*    */   
/*    */   public int sizeH(DIV_SPEC div) {
/* 39 */     return size(div) / 2;
/*    */   }
/*    */   
/*    */   public int size(Div div) {
/* 43 */     int am = 0;
/* 44 */     for (int i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 45 */       EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 46 */       if (b.stat().div().get(div) > 0)
/* 47 */         am = Math.max(b.formationAdd, am); 
/*    */     } 
/* 49 */     return (int)(((div.race()).physics.hitBoxsize() + am) * this.size);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DIV_FORMATION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */