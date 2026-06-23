/*     */ package view.ui;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.emmi.EmiType;
/*     */ import game.faction.player.emmi.EmiTypeReg;
/*     */ import game.faction.player.emmi.EmiTypeRoy;
/*     */ import game.faction.royalty.Royalty;
/*     */ import snake2d.MButt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import world.WORLD;
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
/*     */ class null
/*     */   extends GTableBuilder
/*     */ {
/*     */   public int nrOFEntries() {
/*  77 */     if (MButt.LEFT.isDown() && UIEmissaries.this.tot > 0) {
/*  78 */       return UIEmissaries.this.tot;
/*     */     }
/*     */     
/*  81 */     UIEmissaries.this.tot = 0;
/*  82 */     for (Region reg : WORLD.REGIONS().active()) {
/*  83 */       if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */         break; 
/*  85 */       for (EmiTypeReg t : (FACTIONS.player()).emissaries.regs) {
/*  86 */         if (t.get(reg) > 0) {
/*     */           
/*  88 */           ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).reg = reg;
/*  89 */           ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).t = (EmiType<?>)t;
/*  90 */           ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).treg = (EmiType<Region>)t;
/*  91 */           UIEmissaries.this.tot++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  97 */     for (FactionNPC f : FACTIONS.NPCs()) {
/*  98 */       if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */         break; 
/* 100 */       for (EmiTypeRoy t : (FACTIONS.player()).emissaries.roys) {
/* 101 */         for (Royalty r : f.court().all()) {
/* 102 */           if (t.get(r) > 0) {
/* 103 */             if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */               break; 
/* 105 */             ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).roy = r;
/* 106 */             ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).t = (EmiType<?>)t;
/* 107 */             ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).troy = t;
/* 108 */             UIEmissaries.this.tot++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 115 */     return UIEmissaries.this.tot;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\UIEmissaries$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */