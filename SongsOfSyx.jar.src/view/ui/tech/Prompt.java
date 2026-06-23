/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.settings.S;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCost;
/*     */ import init.tech.TechCurrency;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Prompt
/*     */ {
/*  20 */   private static CharSequence ¤¤Unlock = "¤Do you wish to unlock the following:";
/*  21 */   private static CharSequence ¤¤Unlock2 = "¤For the cost of:";
/*  22 */   private static CharSequence ¤¤Forget = "¤Do you wish to forget the following technologies? 50% of the points deallocated will be frozen for some time.";
/*     */   
/*  24 */   private double renderS = VIEW.renderSecond() - 60.0D;
/*  25 */   private boolean[] checks = new boolean[TECHS.ALL().size()];
/*  26 */   private double checkFoget = VIEW.renderSecond();
/*     */   
/*     */   static {
/*  29 */     D.ts(Prompt.class);
/*     */   }
/*     */   
/*  32 */   private int[] costs = Alloc.ii(TECHS.COSTS().size());
/*     */   
/*     */   public void unlock(TECH tech) {
/*  35 */     if (FACTIONS.player().tech().level(tech) == tech.levelMax)
/*     */       return; 
/*  37 */     if (!FACTIONS.player().tech().canUnlockNext(tech) && !(S.get()).developer) {
/*     */       return;
/*     */     }
/*  40 */     for (TechCurrency c : TECHS.COSTS()) {
/*  41 */       this.costs[c.index] = FACTIONS.player().tech().costOfRequired(c, tech);
/*     */     }
/*     */     
/*  44 */     for (TechCost c : tech.costs) {
/*  45 */       this.costs[c.cu.index] = this.costs[c.cu.index] + (FACTIONS.player()).tech.costLevelNext(c.amount, tech);
/*     */     }
/*     */     
/*  48 */     if (VIEW.renderSecond() > this.renderS) {
/*  49 */       Str s = Str.TMP;
/*  50 */       s.clear();
/*  51 */       s.add(¤¤Unlock);
/*  52 */       s.NL();
/*  53 */       Arrays.fill(this.checks, false);
/*  54 */       addUnlocks(tech, s);
/*  55 */       s.add(¤¤Unlock2);
/*  56 */       s.NL();
/*  57 */       for (TechCurrency c2 : TECHS.COSTS()) {
/*  58 */         if (this.costs[c2.index] > 0)
/*  59 */           s.add(c2.bo.name).s().add(this.costs[c2.index]); 
/*  60 */         s.NL();
/*     */       } 
/*     */       
/*  63 */       this.tech = tech;
/*  64 */       (VIEW.inters()).yesNo.activate((CharSequence)s, this.askUnlock, this.askNo, true);
/*  65 */       this.renderS = VIEW.renderSecond() + 120.0D;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  71 */     pUnlock(tech, FACTIONS.player().tech().level(tech) + 1);
/*     */   }
/*     */   
/*     */   private TECH tech;
/*     */   
/*     */   private void addUnlocks(TECH tech, Str s) {
/*  77 */     if (this.checks[tech.index()])
/*     */       return; 
/*  79 */     this.checks[tech.index()] = true;
/*  80 */     s.add(tech.name());
/*  81 */     s.NL();
/*  82 */     for (int i = 0; i < tech.requires().size(); i++) {
/*  83 */       TECH.TechRequirement r = (TECH.TechRequirement)tech.requires().get(i);
/*  84 */       if (FACTIONS.player().tech().level(r.tech) < r.level) {
/*  85 */         s.add(r.tech.name());
/*  86 */         if (r.tech.levelMax > 1)
/*  87 */           s.s().add(r.level); 
/*  88 */         s.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void pUnlock(TECH tech, int level) {
/*  95 */     for (int i = 0; i < tech.requires().size(); i++) {
/*  96 */       TECH.TechRequirement r = (TECH.TechRequirement)tech.requires().get(i);
/*  97 */       if (FACTIONS.player().tech().level(r.tech) < r.level) {
/*  98 */         pUnlock(r.tech, r.level);
/*     */       }
/*     */     } 
/* 101 */     FACTIONS.player().tech().levelSet(tech, level);
/*     */   }
/*     */   
/*     */   public void forget(TECH tech) {
/* 105 */     int l = FACTIONS.player().tech().level(tech);
/* 106 */     if (l == 0) {
/*     */       return;
/*     */     }
/* 109 */     int am = 1;
/* 110 */     Str s = Str.TMP;
/* 111 */     s.clear();
/* 112 */     s.add(¤¤Forget);
/* 113 */     s.NL();
/* 114 */     s.add(tech.name());
/* 115 */     s.NL();
/* 116 */     for (int ti = 0; ti < TECHS.ALL().size(); ti++) {
/* 117 */       TECH t = (TECH)TECHS.ALL().get(ti);
/* 118 */       if (t != tech && t.requires(tech, l - 1) && FACTIONS.player().tech().level(t) > 0) {
/*     */         
/* 120 */         s.add(t.name());
/* 121 */         s.NL();
/* 122 */         am++;
/*     */       } 
/*     */     } 
/* 125 */     this.tech = tech;
/*     */     
/* 127 */     if (am > 2 || VIEW.renderSecond() - this.checkFoget > 60.0D) {
/* 128 */       (VIEW.inters()).yesNo.activate((CharSequence)s, this.askforget, this.askNo, true);
/* 129 */       this.checkFoget = VIEW.renderSecond();
/*     */     } else {
/* 131 */       this.askforget.exe();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 137 */   private ACTION askforget = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 141 */         int l = FACTIONS.player().tech().level(Prompt.this.tech);
/* 142 */         for (int ti = 0; ti < TECHS.ALL().size(); ti++) {
/* 143 */           TECH t = (TECH)TECHS.ALL().get(ti);
/* 144 */           if (t != Prompt.this.tech && t.requires(Prompt.this.tech, l - 1)) {
/* 145 */             FACTIONS.player().tech().levelSet(t, 0);
/*     */           }
/*     */         } 
/*     */         
/* 149 */         FACTIONS.player().tech().levelSet(Prompt.this.tech, l - 1);
/*     */       }
/*     */     };
/*     */   
/* 153 */   private ACTION askUnlock = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 157 */         Prompt.this.pUnlock(Prompt.this.tech, FACTIONS.player().tech().level(Prompt.this.tech) + 1);
/*     */       }
/*     */     };
/*     */   
/* 161 */   private ACTION askNo = new ACTION() {
/*     */       public void exe() {}
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Prompt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */