/*     */ package view.world.ui.region;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class OtherHov {
/*  25 */   private final GETTER.GETTER_IMP<Region> g = new GETTER.GETTER_IMP();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   private static CharSequence ¤¤Besieged = "¤Besieged!";
/*     */   
/*     */   static {
/*  34 */     D.ts(OtherHov.class);
/*     */   }
/*     */   
/*     */   void hover(Region reg, GUI_BOX box) {
/*  38 */     this.g.set(reg);
/*  39 */     Str.TMP.clear().add((CharSequence)reg.info.name());
/*  40 */     box.title((CharSequence)Str.TMP);
/*  41 */     GBox b = (GBox)box;
/*     */     
/*  43 */     if (reg.faction() == null) {
/*  44 */       b.add(FBanner.rebel.BIG);
/*  45 */       b.text(Dic.¤¤NoRuler);
/*     */     }
/*     */     else {
/*     */       
/*  49 */       FactionNPC f = (FactionNPC)reg.faction();
/*  50 */       if (reg.capitol()) {
/*  51 */         b.add((SPRITE)(UI.icons()).s.crown);
/*     */       }
/*  53 */       b.add((f.banner()).BIG);
/*  54 */       b.textLL((CharSequence)f.name);
/*     */     } 
/*     */ 
/*     */     
/*  58 */     b.tab(9);
/*  59 */     b.add((SPRITE)((RD.RACES()).visuals.cRace(reg).appearance()).icon);
/*  60 */     b.add((SPRITE)GFORMAT.i(b.text(), (RD.RACES()).population.get(reg)));
/*     */     
/*  62 */     b.NL();
/*  63 */     b.add((SPRITE)(UI.icons()).s.sword);
/*  64 */     if ((RD.OWNER()).affiliation.get(this.g.get()) >= 0.5D) {
/*  65 */       b.add((SPRITE)GFORMAT.i(b.text(), (RD.MILITARY()).garrison.get(reg)));
/*     */     } else {
/*  67 */       b.add((SPRITE)b.text().add('?'));
/*  68 */     }  b.tab(3);
/*  69 */     b.add((SPRITE)(UI.icons()).s.flag);
/*  70 */     b.add((SPRITE)GFORMAT.perc(b.text(), (RD.OWNER()).affiliation.getD(reg)));
/*  71 */     b.tab(6);
/*  72 */     b.add((SPRITE)(UI.icons()).s.flags);
/*  73 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).emissaries.assimilate.get(reg)));
/*     */     
/*  75 */     if (reg.faction() != null) {
/*  76 */       b.tab(9);
/*  77 */       FactionNPC f = (FactionNPC)reg.faction();
/*  78 */       if (DIP.WAR().is((Faction)FACTIONS.player(), reg.faction())) {
/*  79 */         b.error(Dic.¤¤AtWar);
/*     */       } else {
/*  81 */         b.add((SPRITE)(UI.icons()).s.heart);
/*  82 */         b.add((SPRITE)GFORMAT.perc(b.text(), ROPINION.get(f.court().king().roy())));
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     hovSiege(reg, box);
/*     */ 
/*     */     
/*  89 */     if ((S.get()).developer) {
/*  90 */       box.NL();
/*  91 */       b.add((SPRITE)b.text().add(1L).s().add(FACTIONS.player().realm().regions()));
/*  92 */       b.NL();
/*  93 */       b.add((SPRITE)b.text().add(2L).s().add(RD.DIST().reachable(reg)));
/*  94 */       b.NL();
/*  95 */       if (reg.faction() != null) {
/*  96 */         b.add((SPRITE)b.text().add(3L).s().add(((FactionNPC)reg.faction()).sanctified));
/*     */       }
/*     */       
/*  99 */       box.NL();
/* 100 */       b.add((SPRITE)b.text().add("pop ").s().add(RD.RACES().popSize(reg)));
/* 101 */       b.add((SPRITE)b.text().add("popT ").s().add(RD.RACES().popSizeTarget(reg)));
/* 102 */       b.add((SPRITE)b.text().add("popD ").s().add(RD.RACES().popSizeD(reg)));
/* 103 */       b.add((SPRITE)b.text().add("capT ").s().add(RD.RACES().capacity(reg)));
/* 104 */       b.NL();
/* 105 */       b.add((SPRITE)b.text().add(2L).s().add(RD.DIST().reachable(reg)));
/* 106 */       b.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hovSiege(Region reg, GUI_BOX box) {
/* 113 */     GBox b = (GBox)box;
/* 114 */     if (reg.besieged()) {
/* 115 */       b.NL(8);
/* 116 */       b.error(¤¤Besieged);
/* 117 */       b.NL();
/* 118 */       GText t = b.text();
/* 119 */       DicTime.setYearDay((Str)t, WORLD.BATTLES().besigedTime(reg));
/* 120 */       b.add((SPRITE)t);
/* 121 */       b.NL();
/* 122 */       b.textL(Dic.¤¤Defences);
/* 123 */       b.tab(6);
/* 124 */       b.add((SPRITE)GFORMAT.f0(b.text(), RD.MILITARY().defensePower(reg)));
/* 125 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\OtherHov.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */