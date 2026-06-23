/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.text.Dic;
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
/*     */ class AA
/*     */   implements ACTION
/*     */ {
/*     */   private Race race;
/*     */   private DivType type;
/*     */   
/* 112 */   private DIV_SPEC stats = new DIV_SPEC()
/*     */     {
/*     */       public double training(StatsBattle.StatTraining tr)
/*     */       {
/* 116 */         return DivTypes.AA.this.type.training(tr);
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/* 121 */         return DivTypes.AA.this.type.equip(e);
/*     */       }
/*     */ 
/*     */       
/*     */       public Race race() {
/* 126 */         return DivTypes.AA.this.race;
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/* 131 */         return 10;
/*     */       }
/*     */ 
/*     */       
/*     */       public Faction faction() {
/* 136 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public double experience() {
/* 141 */         return 0.2D;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name() {
/* 146 */         return Dic.empty;
/*     */       }
/*     */ 
/*     */       
/*     */       public int bannerI() {
/* 151 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe() {
/* 158 */     for (DivType t : DivTypes.this.types) {
/* 159 */       this.type = t;
/* 160 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*     */ 
/*     */         
/* 163 */         this.race = (Race)RACES.all().get(ri);
/* 164 */         if (!t.valid(this.race)) {
/* 165 */           this.type.roccurence[ri] = 0.0D;
/*     */         } else {
/* 167 */           this.type.roccurence[ri] = this.type.occurence * (GAME.battle()).power.get(this.stats);
/*     */         } 
/* 169 */         DivTypes.this.occMaxs[ri] = DivTypes.this.occMaxs[ri] + this.type.roccurence[ri];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivTypes$AA.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */