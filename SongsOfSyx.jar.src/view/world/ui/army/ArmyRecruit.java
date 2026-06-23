/*     */ package view.world.ui.army;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.div.UIDivCardWorld;
/*     */ import view.ui.div.UIDivEditor;
/*     */ import world.army.AD;
/*     */ import world.army.WDivRegional;
/*     */ 
/*     */ class ArmyRecruit extends GuiSection {
/*  35 */   static CharSequence ¤¤Full = "¤Army unit limit reached!";
/*  36 */   static CharSequence ¤¤NoMapnpower = "¤Insufficient Conscripts available of selected race!";
/*  37 */   static CharSequence ¤¤Time = "¤The amount of days it will take to train this division to specification.";
/*     */   static {
/*  39 */     D.ts(ArmyRecruit.class);
/*     */   }
/*     */   
/*  42 */   private final UIDivEditor editor = new UIDivEditor(0.75D, false, false, false, RACES.playable());
/*     */ 
/*     */ 
/*     */   
/*     */   ArmyRecruit() {
/*  47 */     add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  51 */             GFORMAT.i(text, AD.conscripts().available(ArmyRecruit.this.editor.div().race()).get(FACTIONS.player()));
/*     */           }
/*  53 */         }).hh(Dic.¤¤Conscripts));
/*     */     
/*  55 */     addRelBody(4, DIR.S, (RENDEROBJ)this.editor);
/*     */ 
/*     */     
/*  58 */     GuiSection row = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  62 */     GStat ss = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/*  67 */           GFORMAT.i(text, (long)ti());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/*  72 */           b.text(ArmyRecruit.¤¤Time);
/*     */         }
/*     */ 
/*     */         
/*     */         double ti() {
/*  77 */           int am = WDivRegional.DAYS_TO_TRAIN;
/*     */           
/*  79 */           for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/*  80 */             am += WDivRegional.trainingDays(t, ArmyRecruit.this.editor.div().training(t), (Faction)FACTIONS.player());
/*     */           }
/*     */           
/*  83 */           return am;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  89 */     row.addRightC(48, (RENDEROBJ)ss.hh((SPRITE)(SPRITES.icons()).m.time));
/*     */     
/*  91 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel(Dic.¤¤Recruit)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  95 */           if (Army.army.divs().canAdd()) {
/*  96 */             WDivRegional d = AD.regional().create(ArmyRecruit.this.editor.div().race(), ArmyRecruit.this.editor.div().men() / (Config.battle()).MEN_PER_DIVISION, Army.army);
/*  97 */             d.bannerSet(ArmyRecruit.this.editor.div().bannerI());
/*     */             
/*  99 */             for (ResSupply s : (RESOURCES.SUP()).ALL) {
/* 100 */               if (s.health <= 0.0D)
/*     */                 continue; 
/* 102 */               int am = s.amount(ArmyRecruit.this.editor.div().race(), ArmyRecruit.this.editor.div().men());
/* 103 */               am = CLAMP.i(am, 0, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource));
/* 104 */               if (am > 0) {
/* 105 */                 s.resource.remove(am, FResources.RTYPE.ARMY_SUPPLY);
/* 106 */                 AD.supplies().get(s).current().inc(Army.army, am);
/*     */               } 
/*     */             } 
/*     */             
/* 110 */             for (StatsBattle.StatTraining s : (STATS.BATTLE()).TRAINING_ALL) {
/* 111 */               d.target.trainingSet(s, ArmyRecruit.this.editor.div().training(s));
/*     */             }
/*     */             
/* 114 */             for (EquipBattle s : STATS.EQUIP().BATTLE_ALL()) {
/* 115 */               d.target.equipSet(s, ArmyRecruit.this.editor.div().equip(s));
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 125 */           activeSet((ArmyRecruit.this.problem() == null));
/*     */         }
/*     */         
/* 128 */         private final ArrayList<DIV_SPEC> li = new ArrayList(1);
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 132 */           this.li.clearSloppy();
/* 133 */           this.li.add(ArmyRecruit.this.editor.div());
/* 134 */           UIDivCardWorld.hoverSendOut((LIST)this.li, text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 139 */     row.addRightC(48, (RENDEROBJ)buttPanel);
/*     */     
/* 141 */     addRelBody(8, DIR.S, (RENDEROBJ)row);
/*     */ 
/*     */ 
/*     */     
/* 145 */     add((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 149 */             text.setMaxWidth(ArmyRecruit.this.body().width());
/* 150 */             text.setMultipleLines(true);
/* 151 */             CharSequence p = ArmyRecruit.this.problem();
/* 152 */             if (p != null) {
/* 153 */               text.errorify().add(p);
/*     */             } else {
/* 155 */               p = ArmyRecruit.this.warning();
/* 156 */               if (p != null)
/* 157 */                 text.warnify().add(p); 
/*     */             } 
/*     */           }
/* 160 */         },  body().x1(), body().y2() + 8);
/*     */     
/* 162 */     body().incrH(((UI.FONT()).S.height() * 4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence problem() {
/* 168 */     if (!Army.army.divs().canAdd()) {
/* 169 */       return ¤¤Full;
/*     */     }
/*     */     
/* 172 */     if (this.editor.div().men() > AD.conscripts().available(this.editor.div().race()).get(FACTIONS.player())) {
/* 173 */       return ¤¤NoMapnpower;
/*     */     }
/*     */     
/* 176 */     if (UIDivCardWorld.supplyError((DIV_SIMPLE)this.editor.div()) != null) {
/* 177 */       return UIDivCardWorld.supplyError((DIV_SIMPLE)this.editor.div());
/*     */     }
/* 179 */     return null;
/*     */   }
/*     */   
/*     */   private CharSequence warning() {
/* 183 */     if (this.editor.div().men() > AD.conscripts().available(this.editor.div().race()).get(FACTIONS.player())) {
/* 184 */       return ¤¤NoMapnpower;
/*     */     }
/*     */     
/* 187 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ArmyRecruit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */