/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ class WarCriminals extends GuiSection {
/*  36 */   private static CharSequence ¤¤apply = "Apply";
/*  37 */   private static CharSequence ¤¤per100 = "({0} increase for 100 captives)";
/*  38 */   private static CharSequence ¤¤selected = "Selected";
/*  39 */   private static CharSequence ¤¤assign = "Manually assign available captives to this punishment.";
/*     */   
/*     */   static {
/*  42 */     D.ts(WarCriminals.class);
/*     */   }
/*     */   
/*  45 */   private int[] punishments = Alloc.ii(CRIME_PUNISHMENTS.ALL().size());
/*     */   
/*     */   private final Selector sel;
/*     */   
/*     */   WarCriminals(int HEIGHT) {
/*  50 */     this.sel = new Selector(HEIGHT, (LIST<CRIMES.CRIME>)new ArrayList(CRIMES.WAR()));
/*     */     
/*  52 */     add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  56 */             GFORMAT.perc(text, (STATS.BATTLE()).CHIVALRY.data().getD(null));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  61 */             (STATS.BATTLE()).CHIVALRY.hover((GUI_BOX)b, HCLASSES.CITIZEN(), null);
/*     */           }
/*  64 */         }).increase().hh(((STATS.BATTLE()).CHIVALRY.info()).icon, ((STATS.BATTLE()).CHIVALRY.info()).name, 180));
/*     */     
/*  66 */     addDown(8, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  70 */             GFORMAT.perc(text, (STATS.BATTLE()).CRUELTY.data().getD(null));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  75 */             (STATS.BATTLE()).CRUELTY.hover((GUI_BOX)b, HCLASSES.CITIZEN(), null);
/*     */           }
/*  78 */         }).increase().hh(((STATS.BATTLE()).CRUELTY.info()).icon, ((STATS.BATTLE()).CRUELTY.info()).name, 180));
/*     */ 
/*     */     
/*  81 */     GuiSection s = new GuiSection();
/*     */     
/*  83 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(HCLASSES.OTHER())) {
/*  84 */       s.addRightC(0, autoPunish(p));
/*     */     }
/*  86 */     addDownC(8, (RENDEROBJ)s);
/*     */ 
/*     */     
/*  89 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(HCLASSES.OTHER())) {
/*  90 */       addDownC(8, row(p));
/*     */     }
/*     */     
/*  93 */     addRelBody(8, DIR.W, (RENDEROBJ)this.sel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 100 */     Arrays.fill(this.punishments, 0); byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 102 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 103 */       if (e instanceof Humanoid) {
/* 104 */         Humanoid a = (Humanoid)e;
/* 105 */         if (a.indu().hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(a.indu()) == CRIMES.WAR() && (
/* 106 */           this.sel.getRace() == null || this.sel.getRace() == a.race())) {
/* 107 */           this.punishments[AIModule_Prisoner.punishment(a, a.ai()).index()] = this.punishments[AIModule_Prisoner.punishment(a, a.ai()).index()] + 1;
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/* 112 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ row(final CRIME_PUNISHMENTS.PUNISHMENT punish) {
/* 119 */     final INT.INTE ii = new INT.INTE()
/*     */       {
/* 121 */         int i = 0;
/*     */ 
/*     */         
/*     */         public int get() {
/* 125 */           return CLAMP.i(this.i, 0, max());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 130 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 135 */           return CRIMES.WAR().stat().criminals(WarCriminals.this.sel.getRace()) - WarCriminals.this.punishments[punish.index()];
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 140 */           this.i = CLAMP.i(t, 0, max());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 145 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 149 */           GBox b = (GBox)text;
/* 150 */           b.title(punish.action);
/* 151 */           b.text(WarCriminals.¤¤assign);
/* 152 */           b.NL();
/*     */           
/* 154 */           b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 155 */           b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 156 */           b.tab(6);
/* 157 */           b.add((SPRITE)GFORMAT.perc(b.text(), punish.mercyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 158 */           b.NL();
/*     */           
/* 160 */           b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 161 */           b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 162 */           b.tab(6);
/* 163 */           b.add((SPRITE)GFORMAT.perc(b.text(), punish.crueltyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 164 */           b.NL();
/*     */           
/* 166 */           b.sep();
/*     */ 
/*     */           
/* 169 */           b.NL(8);
/* 170 */           b.textLL(WarCriminals.¤¤selected);
/* 171 */           b.tab(6);
/* 172 */           b.add((SPRITE)GFORMAT.i(b.text(), ii.get()));
/* 173 */           b.NL();
/*     */ 
/*     */           
/* 176 */           b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 177 */           b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 178 */           b.tab(6);
/* 179 */           b.text((CharSequence)GFORMAT.f0(b.text(), ii.get() * punish.mercyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 180 */           b.NL();
/*     */           
/* 182 */           b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 183 */           b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 184 */           b.tab(6);
/* 185 */           b.text((CharSequence)GFORMAT.f0(b.text(), ii.get() * punish.crueltyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 186 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     ss.add((SPRITE)punish.icon, 0, 0);
/* 194 */     ss.addRightC(8, (RENDEROBJ)new GHeader(punish.name));
/*     */ 
/*     */ 
/*     */     
/* 198 */     ss.addRightCAbs(200, (RENDEROBJ)new GSliderInt(ii, 100, true));
/*     */     
/* 200 */     ss.addRightC(16, (RENDEROBJ)new GButt.ButtPanel(¤¤apply)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 204 */             activeSet((ii.get() > 0));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 210 */             int am = ii.get(); byte b; int i;
/*     */             ENTITY[] arrayOfENTITY;
/* 212 */             for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 213 */               if (am <= 0)
/*     */                 break; 
/* 215 */               if (e instanceof Humanoid) {
/* 216 */                 Humanoid a = (Humanoid)e;
/* 217 */                 if (a.indu().hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(a.indu()) == CRIMES.WAR() && (
/* 218 */                   WarCriminals.this.sel.getRace() == null || WarCriminals.this.sel.getRace() == a.race()) && 
/* 219 */                   (AIModule_Prisoner.DATA()).punishmentSet.get(a.ai()) == CRIME_PUNISHMENTS.STOCKS()) {
/* 220 */                   (AIModule_Prisoner.DATA()).punishmentSet.set(a.ai(), punish);
/* 221 */                   am--;
/* 222 */                   if (am <= 0) {
/*     */                     break;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */               
/*     */               b++; }
/*     */             
/* 230 */             for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 231 */               if (am <= 0)
/*     */                 break; 
/* 233 */               if (e instanceof Humanoid) {
/* 234 */                 Humanoid a = (Humanoid)e;
/* 235 */                 if (a.indu().hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(a.indu()) == CRIMES.WAR() && (
/* 236 */                   WarCriminals.this.sel.getRace() == null || WarCriminals.this.sel.getRace() == a.race()) && 
/* 237 */                   (AIModule_Prisoner.DATA()).punishmentSet.get(a.ai()) != punish) {
/* 238 */                   (AIModule_Prisoner.DATA()).punishmentSet.set(a.ai(), punish);
/* 239 */                   am--;
/* 240 */                   if (am <= 0) {
/*     */                     break;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/*     */               b++; }
/*     */           
/*     */           }
/*     */         });
/*     */     
/* 252 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ autoPunish(final CRIME_PUNISHMENTS.PUNISHMENT punish) {
/* 257 */     return (RENDEROBJ)new GButt.ButtPanel(punish.icon.scaled(2.0D))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 261 */           ((StatCrime)(STATS.LAW()).crimes.get(CRIMES.WAR().index())).punishmentSet(HCLASSES.OTHER(), WarCriminals.this.sel.getRace(), punish);
/* 262 */           super.clickA();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 267 */           selectedSet(((((StatCrime)(STATS.LAW()).crimes.get(CRIMES.WAR().index())).punishment(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())).punish == punish));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 272 */           GBox b = (GBox)text;
/* 273 */           b.title(punish.action);
/* 274 */           b.text(punish.desc);
/* 275 */           b.sep();
/*     */           
/* 277 */           b.add(((STATS.BATTLE()).CHIVALRY.info()).icon);
/* 278 */           b.textLL(((STATS.BATTLE()).CHIVALRY.info()).name);
/* 279 */           b.tab(6);
/* 280 */           b.add((SPRITE)GFORMAT.perc(b.text(), punish.mercyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 281 */           b.tab(8);
/* 282 */           b.text((CharSequence)b.text().add(WarCriminals.¤¤per100).insert(0, 100.0D * punish.mercyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace()), 4));
/* 283 */           b.NL(8);
/*     */           
/* 285 */           b.add(((STATS.BATTLE()).CRUELTY.info()).icon);
/* 286 */           b.textLL(((STATS.BATTLE()).CRUELTY.info()).name);
/* 287 */           b.tab(6);
/* 288 */           b.add((SPRITE)GFORMAT.perc(b.text(), punish.crueltyValue(HCLASSES.OTHER(), WarCriminals.this.sel.getRace())));
/* 289 */           b.NL();
/* 290 */           b.text((CharSequence)b.text().add(WarCriminals.¤¤per100).insert(0, 100.0D * punish.crueltyPerPerson(HCLASSES.OTHER(), WarCriminals.this.sel.getRace()), 4));
/* 291 */           b.NL();
/*     */ 
/*     */           
/* 294 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\WarCriminals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */