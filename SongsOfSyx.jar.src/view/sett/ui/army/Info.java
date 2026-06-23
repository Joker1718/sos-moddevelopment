/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GFrame;
/*     */ import util.gui.slider.GGauge;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ 
/*     */ class Info extends GuiSection {
/*  30 */   private static CharSequence ¤¤RecruitD = "¤The amount of men currently training to be able to join a division.";
/*  31 */   private static CharSequence ¤¤SoldierD = "The amount of soldiers that are ready to be deployed in your city.";
/*  32 */   private static CharSequence ¤¤Campaigning = "¤Campaigning";
/*  33 */   private static CharSequence ¤¤CampaigningD = "¤Soldiers that are out campaigning.";
/*     */   
/*     */   static {
/*  36 */     D.ts(Info.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Info() {
/*  42 */     int gi = 0;
/*  43 */     int wi = 100;
/*  44 */     int hi = 58;
/*  45 */     int cols = 6;
/*  46 */     DIR al = DIR.N;
/*     */     
/*  48 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  52 */             GFORMAT.iBig(text, AD.cityDivs().total());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  57 */             b.title(Info.¤¤Campaigning);
/*  58 */             b.text(Info.¤¤CampaigningD);
/*  59 */             b.NL();
/*  60 */             b.add((SPRITE)GFORMAT.iBig(b.text(), AD.cityDivs().total()));
/*     */           }
/*  62 */         }).hv((SPRITE)(SPRITES.icons()).m.arrow_left), gi++, cols, wi, hi, al);
/*     */     
/*  64 */     addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  68 */             GFORMAT.iofk(text, (STATS.BATTLE()).DIV.stat().data().get(null, 0), (SETT.BATTLE()).info.targetMen());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  73 */             b.title(Dic.¤¤Soldiers);
/*  74 */             b.text(Info.¤¤SoldierD);
/*  75 */             b.NL();
/*  76 */             b.add((SPRITE)GFORMAT.iBig(b.text(), (STATS.BATTLE()).DIV.stat().data().get(null, 0)));
/*  77 */             b.NL(4);
/*     */             
/*  79 */             b.textLL(Dic.¤¤Recruits);
/*  80 */             b.add((SPRITE)GFORMAT.iBig(b.text(), (STATS.BATTLE()).RECRUIT.stat().data().get(null, 0)));
/*  81 */             b.NL();
/*  82 */             b.text(Info.¤¤RecruitD);
/*     */           }
/*  85 */         }).hv((SPRITE)(SPRITES.icons()).m.sword), gi++, cols, wi, hi, al);
/*     */     
/*  87 */     for (ROOM_M_TRAINER<?> ro : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/*  88 */       addGridD((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  92 */               GFORMAT.iofk(text, ro.employment().employed(), ro.employment().neededWorkers());
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/*  97 */               b.title(ro.tInfo.name);
/*  98 */               b.text(ro.tInfo.desc);
/*  99 */               b.NL(4);
/* 100 */               b.textLL(ro.info.names);
/* 101 */               b.add((SPRITE)GFORMAT.iofk(b.text(), ro.employment().employed(), ro.employment().neededWorkers()));
/*     */               
/* 103 */               b.NL(8);
/* 104 */               b.NL();
/*     */               
/* 106 */               ro.boosters.hover((GUI_BOX)b, 1.0D, -1);
/*     */             }
/* 109 */           }).hv((SPRITE)ro.icon), gi++, cols, wi, hi, al);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 114 */     for (EquipBattle e : STATS.EQUIP().BATTLE_MELEE()) {
/*     */       
/* 116 */       GGauge g = new GGauge(40, 16, GMeter.C_REDGREEN)
/*     */         {
/*     */           public double getD()
/*     */           {
/* 120 */             int needs = 0;
/* 121 */             double has = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(e.resource());
/* 122 */             for (Div d : GAME.ARMIES().player().divisions()) {
/* 123 */               has += e.stat().div().get(d);
/* 124 */               needs += d.info.men() * e.target(d);
/*     */             } 
/* 126 */             return CLAMP.d(has / needs, 0.0D, 1.0D);
/*     */           }
/*     */         };
/* 129 */       addGridD((RENDEROBJ)new CLICKABLE.Pair((RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)e.resource.icon()), (RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)g), DIR.S, 4)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 132 */               GBox b = (GBox)text;
/* 133 */               b.title((e.stat().info()).name);
/* 134 */               b.text((e.stat().info()).desc);
/* 135 */               b.NL(4);
/* 136 */               int needs = 0;
/* 137 */               int has = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(e.resource());
/* 138 */               for (Div d : GAME.ARMIES().player().divisions()) {
/*     */                 
/* 140 */                 has += e.stat().div().get(d);
/* 141 */                 needs += d.info.men() * e.target(d);
/*     */               } 
/* 143 */               b.add((SPRITE)GFORMAT.iofkInv(b.text(), has, needs));
/* 144 */               b.NL(4);
/* 145 */               b.textLL(Dic.¤¤Boosts);
/* 146 */               b.NL(4);
/* 147 */               (e.stat()).boosters.hover(text, 1.0D, -1);
/*     */             }
/* 150 */           }gi++, cols, wi, hi, al);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 155 */     for (EquipRange e : STATS.EQUIP().RANGED()) {
/* 156 */       GGauge g = new GGauge(48, 16, GMeter.C_REDGREEN)
/*     */         {
/*     */           public double getD()
/*     */           {
/* 160 */             int needs = 0;
/* 161 */             double has = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(e.resource());
/* 162 */             for (Div d : GAME.ARMIES().player().divisions()) {
/* 163 */               has += e.stat().div().get(d);
/* 164 */               needs += d.info.men() * e.target(d);
/*     */             } 
/* 166 */             return CLAMP.d(has / needs, 0.0D, 1.0D);
/*     */           }
/*     */         };
/*     */       
/* 170 */       addGridD((RENDEROBJ)new CLICKABLE.Pair((RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)e.resource.icon()), (RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)g), DIR.S, 4)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 173 */               GBox b = (GBox)text;
/* 174 */               b.title((e.stat().info()).name);
/* 175 */               b.text((e.stat().info()).desc);
/* 176 */               b.NL(4);
/* 177 */               int needs = 0;
/* 178 */               int has = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(e.resource());
/* 179 */               for (Div d : GAME.ARMIES().player().divisions()) {
/* 180 */                 has += e.stat().div().get(d);
/* 181 */                 needs += d.info.men() * e.target(d);
/*     */               } 
/* 183 */               b.add((SPRITE)GFORMAT.iofkInv(b.text(), has, needs));
/* 184 */               b.NL(4);
/* 185 */               e.hover(text);
/*     */             }
/* 187 */           }gi++, cols, wi, hi, al);
/*     */     } 
/*     */ 
/*     */     
/* 191 */     addRelBody(6, DIR.S, GFrame.separator(body().width()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Info.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */