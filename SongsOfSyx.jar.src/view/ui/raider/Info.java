/*     */ package view.ui.raider;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.raiding.RaidingMap;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Info extends GuiSection {
/*  23 */   private static CharSequence ¤¤defences = "Defence";
/*  24 */   private static CharSequence ¤¤defencesD = "The power of forces defending your city. This deters raiders.";
/*     */   
/*  26 */   private static CharSequence ¤¤armiesD = "Additional armies encamped near your city.";
/*  27 */   private static CharSequence ¤¤armiesD2 = "Armies encamped in your realm.";
/*  28 */   private static CharSequence ¤¤suprise = "Possible surprise attack";
/*     */   
/*  30 */   private static CharSequence ¤¤Ransom = "Potential Ransom";
/*  31 */   private static CharSequence ¤¤RansomD = "The potential ransom a raider sees fit to extort you with. Based on population and credits, and lowered by raid security.";
/*     */   
/*  33 */   private static CharSequence ¤¤entry = "Attack Route";
/*  34 */   private static CharSequence ¤¤entryA = "Surprise!";
/*  35 */   private static CharSequence ¤¤entryB = "Realm";
/*  36 */   private static CharSequence ¤¤entryAD = "Your capital is surrounded by regions where raiders can sneak in and surprise attack you. This makes them take more risk, and as a result, they perceive your deterrent power as low.";
/*  37 */   private static CharSequence ¤¤entryBD = "Raiders can't surprise attack your city directly. This is good. They must pass through your regions. This will buy you a lot of time if they choose to attack. Your regional defences and armies can deter raiders as well.";
/*     */ 
/*     */   
/*     */   static {
/*  41 */     D.ts(Info.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Info() {
/*  48 */     int gi = 0;
/*  49 */     int mx = 180;
/*     */     
/*  51 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  55 */             GFORMAT.i(text, (GAME.raiders()).util.playerPow());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  60 */             b.text(Info.¤¤defencesD);
/*     */             
/*  62 */             b.NL(16);
/*  63 */             b.textLL(Dic.¤¤garrison);
/*  64 */             b.NL();
/*  65 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(FACTIONS.player().capitolRegion())));
/*  66 */             b.NL(8);
/*     */             
/*  68 */             double pow = 0.0D;
/*  69 */             double pow2 = 0.0D;
/*  70 */             for (WArmy a : FACTIONS.player().armies().all()) {
/*  71 */               if (a.region() == FACTIONS.player().capitolRegion())
/*  72 */                 pow += AD.power().get(a); 
/*  73 */               if (a.region() != null && a.region().faction() == FACTIONS.player()) {
/*  74 */                 pow2 += AD.power().get(a);
/*     */               }
/*     */             } 
/*  77 */             b.textLL(Info.¤¤armiesD);
/*  78 */             b.NL();
/*  79 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)pow));
/*  80 */             b.NL(8);
/*     */             
/*  82 */             b.textLL(Info.¤¤armiesD2);
/*  83 */             b.NL();
/*  84 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)pow2));
/*  85 */             b.NL(8);
/*     */             
/*  87 */             b.textLL(Info.¤¤suprise);
/*  88 */             b.NL();
/*  89 */             if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/*  90 */               int pp = (int)(0.75D * ((RD.MILITARY()).power.getD(FACTIONS.player().capitolRegion()) + pow));
/*  91 */               pp = (int)(pp + pow2);
/*  92 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), -pp));
/*     */             } else {
/*  94 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), 0L));
/*     */             } 
/*  96 */             b.NL(8);
/*     */           }
/* 103 */         }).hv(¤¤defences), gi++, 8, mx, 64, DIR.N);
/*     */     
/* 105 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 110 */             if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/* 111 */               text.errorify().add(Info.¤¤entryA);
/*     */             } else {
/* 113 */               text.normalify().add(Info.¤¤entryB);
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 120 */             if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/* 121 */               b.text(Info.¤¤entryAD);
/*     */             } else {
/* 123 */               b.text(Info.¤¤entryBD);
/* 124 */               b.NL(8);
/* 125 */               for (RaidingMap.RaidRegion r : (GAME.raiders()).entry.entryRegions()) {
/* 126 */                 b.textLL((CharSequence)(r.r()).info.name());
/* 127 */                 b.tab(6);
/* 128 */                 b.add((SPRITE)(UI.icons()).s.sword);
/* 129 */                 b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(r.r())));
/* 130 */                 b.NL();
/*     */               } 
/*     */               
/* 133 */               b.NL(8);
/*     */               
/* 135 */               for (WArmy a : FACTIONS.player().armies().all()) {
/* 136 */                 if (a.region() != null && a.region().faction() == FACTIONS.player()) {
/* 137 */                   b.textLL((CharSequence)a.name);
/* 138 */                   b.tab(6);
/* 139 */                   b.add((SPRITE)(UI.icons()).s.sword);
/* 140 */                   b.add((SPRITE)GFORMAT.iIncr(b.text(), AD.power().get(a)));
/* 141 */                   b.NL();
/*     */                 }
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 149 */         }).hv(¤¤entry), gi++, 8, mx, 64, DIR.N);
/*     */     
/* 151 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 155 */             double d = (BOOSTABLES.CIVICS()).RAID_SECURITY.get((BOOSTABLE_O)HCLASS_RACE.clP());
/* 156 */             GFORMAT.f1(text, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 161 */             (BOOSTABLES.CIVICS()).RAID_SECURITY.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), true);
/*     */           }
/* 164 */         }).hv((BOOSTABLES.CIVICS()).RAID_SECURITY.name), gi++, 8, mx, 64, DIR.N);
/*     */     
/* 166 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 170 */             GFORMAT.i(text, (GAME.raiders()).util.ransomCurrent());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 175 */             b.text(Info.¤¤RansomD);
/*     */           }
/* 178 */         }).hv(¤¤Ransom), gi++, 8, mx, 64, DIR.N);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Info.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */