/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import view.ui.message.MessageText;
/*     */ import world.map.regions.Region;
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
/*     */   implements RD.RDUpdatable
/*     */ {
/*     */   public void update(Region reg, double time) {
/* 149 */     if (reg.faction() == null || reg.faction() instanceof game.faction.npc.FactionNPC) {
/* 150 */       RDHealth.this.set(reg, 255);
/*     */       
/*     */       return;
/*     */     } 
/* 154 */     double b = RDHealth.this.boostablee.get((BOOSTABLE_O)reg);
/* 155 */     boolean bb = RDHealth.this.btoggle;
/* 156 */     RDHealth.this.btoggle = true;
/* 157 */     b = Math.max(b, RDHealth.this.boostablee.get((BOOSTABLE_O)reg));
/*     */     
/* 159 */     int target = CLAMP.i((int)(255.0D * b), 0, 255);
/* 160 */     RDHealth.this.btoggle = bb;
/*     */     
/* 162 */     RDHealth.this.moveTo(reg, time * RDHealth.dTime, target);
/*     */     
/* 164 */     if (reg.faction() == FACTIONS.player() && !reg.capitol()) {
/* 165 */       if (RDHealth.this.get(reg) < 120 && RDHealth.this.outbreak.get(reg) == 0 && target < 120) {
/* 166 */         RDHealth.this.outbreak.set(reg, 1);
/* 167 */         (new MessageText(RDHealth.¤¤epidemic)).paragraph(RDHealth.this.eDesc(reg)).send();
/* 168 */       } else if (RDHealth.this.outbreak.get(reg) == 1 && RDHealth.this.get(reg) > 128 && target > 128) {
/* 169 */         RDHealth.this.outbreak.set(reg, 0);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/* 180 */     RDHealth.this.setD(reg, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDHealth$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */