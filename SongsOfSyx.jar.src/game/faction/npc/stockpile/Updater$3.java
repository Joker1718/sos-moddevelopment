/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.recipe.Recipe;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/*  59 */     KeyMap<Updater.EE> map = new KeyMap();
/*     */     
/*  61 */     double[] rb = new double[SETT.RECIPES().all().size()];
/*  62 */     for (FactionNPC f : FACTIONS.NPCs()) {
/*  63 */       for (Recipe ins : SETT.RECIPES().all()) {
/*  64 */         rb[ins.index] = rb[ins.index] + ins.bo.get((BOOSTABLE_O)f);
/*     */         
/*  66 */         for (Booster b : ins.bo.all()) {
/*  67 */           String k = b.toString();
/*  68 */           if (!map.containsKey(k)) {
/*  69 */             Updater.EE e = new Updater.EE();
/*  70 */             e.bo = b;
/*  71 */             e.t = ins.bo;
/*  72 */             map.put(k, e);
/*     */           } 
/*  74 */           ((Updater.EE)map.get(k)).vv += b.get(f);
/*  75 */           ((Updater.EE)map.get(k)).am++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     for (Recipe r : SETT.RECIPES().all())
/*     */     {
/*  85 */       LOG.ln(String.valueOf(r.name) + " " + String.valueOf(r.name));
/*     */     }
/*     */     
/*  88 */     LOG.ln();
/*     */     
/*  90 */     for (String s : map.keysSorted()) {
/*  91 */       Updater.EE e = (Updater.EE)map.get(s);
/*     */       
/*  93 */       double v = e.vv / e.am;
/*  94 */       if (e.bo.isMul && v == 1.0D)
/*     */         continue; 
/*  96 */       if (!e.bo.isMul && v == 0.0D) {
/*     */         continue;
/*     */       }
/*  99 */       String off = "" + 100 - (int)(100.0D * e.vv / e.am);
/*     */ 
/*     */       
/* 102 */       Object[] ss = {
/* 103 */           String.valueOf(e.bo.info.name), 
/* 104 */           String.format("%.2f", new Object[] { Double.valueOf(e.vv / e.am)
/* 105 */             }), String.valueOf(e.t.name), (
/* 106 */           e.bo.isMul ? "*" : "") + (e.bo.isMul ? "*" : ""), 
/* 107 */           off
/*     */         };
/*     */       
/* 110 */       String sss = String.format("%-20s | %9s | %-25s | %6s | %-5s", ss);
/*     */       
/* 112 */       LOG.ln(sss);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 117 */     KeyMap<Updater.EE> winners = new KeyMap();
/* 118 */     for (Recipe ins : SETT.RECIPES().all()) {
/* 119 */       if (!winners.containsKey(ins.bo.key)) {
/* 120 */         winners.put(ins.bo.key, new Updater.EE());
/*     */       }
/*     */     } 
/*     */     
/* 124 */     for (int i = 0; i < 25 * winners.keys().size(); i++) {
/*     */       
/* 126 */       Arrays.fill(rb, 0.0D);
/* 127 */       SETT.RECIPES().randomizeAIBoosts();
/* 128 */       for (FactionNPC f : FACTIONS.NPCs()) {
/*     */         
/* 130 */         for (Recipe ins : SETT.RECIPES().all()) {
/* 131 */           rb[ins.index] = rb[ins.index] + ins.bo.get((BOOSTABLE_O)f);
/*     */           
/* 133 */           ((Updater.EE)winners.get(ins.bo.key)).vv += ins.bo.get((BOOSTABLE_O)f);
/* 134 */           ((Updater.EE)winners.get(ins.bo.key)).a++;
/*     */         } 
/*     */       } 
/*     */       
/* 138 */       double g = Double.MAX_VALUE;
/* 139 */       Recipe best = null;
/*     */       
/* 141 */       for (Recipe ins : SETT.RECIPES().all()) {
/* 142 */         if (best == null || rb[ins.index] < g) {
/* 143 */           best = ins;
/* 144 */           g = rb[ins.index];
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 149 */       ((Updater.EE)winners.get(best.bo.key)).am++;
/*     */     } 
/*     */     
/* 152 */     for (String k : winners.keysSorted()) {
/*     */ 
/*     */       
/* 155 */       Object[] ss = {
/* 156 */           k, "" + 
/* 157 */           ((Updater.EE)winners.get(k)).am, "" + 
/* 158 */           ((Updater.EE)winners.get(k)).vv / ((Updater.EE)winners.get(k)).a
/*     */         };
/*     */       
/* 161 */       String sss = String.format("%-25s | %9s | %-9s", ss);
/* 162 */       LOG.ln(sss);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\Updater$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */