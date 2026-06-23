/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.tourism.TOURISM;
/*     */ import init.constant.Config;
/*     */ import init.settings.S;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.entity.humanoid.ai.types.tourist.AIModule_Tourist;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ class UISubjectHoverer
/*     */ {
/*     */   private Induvidual indu;
/*     */   private Humanoid hum;
/*  40 */   private static CharSequence ¤¤Sentenced = "Sentenced to be:";
/*  41 */   private static CharSequence ¤¤ClickToChange = "Click to change punishment.";
/*  42 */   private static CharSequence ¤¤JudgedNo = "Pleads innocence. Wants to try case in court.";
/*  43 */   private static CharSequence ¤¤Judged = "Has been found guilty in a court.";
/*  44 */   private static CharSequence ¤¤Soldier = "Serving in your armies abroad.";
/*  45 */   private static CharSequence ¤¤SoldierDiv = "Enlisted in the division: {0}, in the army {1}.";
/*  46 */   private static CharSequence ¤¤SoldierReturn = "Is currently returning to the capitol, will arrive in home in {0} days.";
/*  47 */   private static CharSequence ¤¤yearsOld = "{0} years of age";
/*  48 */   private static CharSequence ¤¤Attraction = "Attraction";
/*  49 */   private static CharSequence ¤¤Service = "Service";
/*  50 */   private static CharSequence ¤¤none = "---";
/*     */   
/*     */   static {
/*  53 */     D.ts(UISubjectHoverer.class);
/*     */   }
/*     */   
/*  56 */   private GuiSection s = new GuiSection();
/*     */ 
/*     */   
/*     */   public UISubjectHoverer() {
/*  60 */     this.s.addRightC(8, (SPRITE)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  64 */             text.lablify();
/*  65 */             text.clear().add(STATS.APPEARANCE().name(UISubjectHoverer.this.indu));
/*  66 */             text.setMaxWidth(300);
/*  67 */             text.setMultipleLines(false);
/*     */           }
/*  69 */         }).increase());
/*     */     
/*  71 */     this.s.add((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text) {
/*     */             Str str;
/*  75 */             text.add((UISubjectHoverer.this.indu.race()).info.namePosessive);
/*  76 */             text.s().add((UISubjectHoverer.this.hum == null) ? (HTYPES.SOLDIER()).name : UISubjectHoverer.this.hum.title());
/*  77 */             if (UISubjectHoverer.this.hum == null) {
/*  78 */               text.add(',').add(UISubjectHoverer.¤¤yearsOld);
/*  79 */               text.insert(0, (int)(STATS.POP()).age.years.getD(UISubjectHoverer.this.indu));
/*     */             } 
/*  81 */             CharSequence extra = null;
/*  82 */             HTYPE t = UISubjectHoverer.this.indu.hType();
/*  83 */             if (t == HTYPES.SLAVE()) {
/*  84 */               extra = (UISubjectHoverer.this.indu.clas()).name;
/*  85 */             } else if (t == HTYPES.PRISONER()) {
/*     */               
/*  87 */               if (((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(UISubjectHoverer.this.indu)).cl == HCLASSES.SLAVE()) {
/*  88 */                 str = Str.TMP.clear().s().add('(').add((HCLASSES.SLAVE()).name).add(')');
/*     */               }
/*  90 */             } else if (t.parent() != t) {
/*  91 */               str = Str.TMP.clear().add((STATS.POP()).age.years.getD(UISubjectHoverer.this.indu), 1).s().add(DicTime.¤¤Years);
/*     */             } 
/*     */             
/*  94 */             if (str != null) {
/*  95 */               text.s().add('(').add((CharSequence)str).add(')');
/*     */             }
/*     */           }
/*  98 */         }0, this.s.body().y2() + 2);
/*     */     
/* 100 */     this.s.addDown(2, (SPRITE)new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 105 */             if (UISubjectHoverer.this.hum == null) {
/* 106 */               text.add(UISubjectHoverer.¤¤Soldier);
/*     */             } else {
/* 108 */               UISubjectHoverer.this.hum.ai().getOccupation(UISubjectHoverer.this.hum, (Str)text);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 113 */     this.s.addRelBody(8, DIR.W, new SPRITE()
/*     */         {
/*     */           public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 121 */             STATS.APPEARANCE().portraitRender(r, UISubjectHoverer.this.indu, X1, Y1, 2);
/*     */           }
/*     */ 
/*     */           
/*     */           public int width() {
/* 126 */             return 80;
/*     */           }
/*     */ 
/*     */           
/*     */           public int height() {
/* 131 */             return 128;
/*     */           }
/*     */         });
/*     */     
/* 135 */     this.s.body().setWidth(550.0D);
/*     */   }
/*     */   
/*     */   void hover(Humanoid h, GBox text) {
/* 139 */     if (h == null)
/*     */       return; 
/* 141 */     this.hum = h;
/* 142 */     this.indu = h.indu();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     if (h.indu().hostile() && !(S.get()).developer) {
/* 149 */       text.error((HTYPES.ENEMY()).name);
/*     */       
/*     */       return;
/*     */     } 
/* 153 */     text.add((RENDEROBJ)this.s);
/* 154 */     text.NL();
/*     */     
/* 156 */     if (SProblem.problem(h) != null) {
/* 157 */       text.add((SPRITE)text.text().errorify().add(SProblem.problem(h)));
/* 158 */       text.NL();
/* 159 */     } else if (SProblem.warning(h) != null) {
/* 160 */       text.add((SPRITE)text.text().warnify().add(SProblem.warning(h)));
/* 161 */       text.NL();
/*     */     } 
/*     */     
/* 164 */     if (h.indu().hType() == HTYPES.PRISONER()) {
/* 165 */       text.text(¤¤Sentenced);
/* 166 */       CRIME_PUNISHMENTS.PUNISHMENT p = AIModule_Prisoner.punishment(h, h.ai());
/* 167 */       text.textLL(p.name);
/* 168 */       if (p == CRIME_PUNISHMENTS.PRISON()) {
/* 169 */         GText t = text.text();
/* 170 */         t.add('(');
/* 171 */         DicTime.setDays((Str)t, (AIModule_Prisoner.DATA()).prisonTimeLeft.get(h.ai()));
/* 172 */         t.add(')');
/* 173 */         text.add((SPRITE)t);
/*     */       } 
/*     */       
/* 176 */       text.NL(4);
/*     */       
/* 178 */       if ((AIModule_Prisoner.DATA()).judged.get(h.ai()) == 0 && ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(h.indu())).isJudged) {
/* 179 */         if ((AIModule_Prisoner.DATA()).judged.get(h.ai()) == 0) {
/* 180 */           text.error(¤¤JudgedNo);
/*     */         } else {
/* 182 */           text.text(¤¤Judged);
/* 183 */         }  text.NL(4);
/*     */       } 
/*     */       
/* 186 */       text.textL(¤¤ClickToChange);
/*     */     }
/* 188 */     else if (h.indu().hType() == HTYPES.TOURIST()) {
/*     */       
/* 190 */       text.textLL((SETT.ROOMS()).INN.info.name);
/* 191 */       text.NL();
/* 192 */       text.add((SPRITE)text.text().add((AIModule_Tourist.inn(h) == null) ? ¤¤none : (CharSequence)AIModule_Tourist.inn(h).name()));
/* 193 */       text.NL(8);
/*     */       
/* 195 */       text.textLL(¤¤Attraction);
/* 196 */       text.NL();
/* 197 */       text.text((TOURISM.attraction(h.indu())).info.name);
/* 198 */       text.NL(8);
/*     */       
/* 200 */       text.textLL(¤¤Service);
/* 201 */       text.NL();
/* 202 */       text.text((TOURISM.service(h.indu()) == null) ? "?" : (TOURISM.service(h.indu())).name);
/* 203 */       text.NL(8);
/*     */       
/* 205 */       text.textLL(Dic.¤¤Curr);
/* 206 */       text.NL();
/* 207 */       text.add((SPRITE)GFORMAT.iBig(text.text(), TOURISM.credits(h.race())));
/* 208 */       text.NL(8);
/*     */     } 
/*     */     
/* 211 */     h.ai().hoverInfoSet(h, text);
/*     */     
/* 213 */     text.NL(8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void hover(Induvidual h, GBox text) {
/* 228 */     if (h == null)
/*     */       return; 
/* 230 */     this.hum = null;
/* 231 */     this.indu = h;
/*     */     
/* 233 */     text.add((RENDEROBJ)this.s);
/* 234 */     text.NL();
/*     */     
/* 236 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 237 */       int m = AD.cityDivs().soldiers(di);
/* 238 */       for (int i = 0; i < m; i++) {
/* 239 */         Induvidual ii = AD.cityDivs().getSoldier(i, di);
/* 240 */         if (ii == h) {
/*     */ 
/*     */           
/* 243 */           Div div = (Div)GAME.ARMIES().player().divisions().get(di);
/* 244 */           GText t = text.text();
/* 245 */           t.add(¤¤SoldierDiv);
/* 246 */           t.insert(0, (CharSequence)div.info.name());
/* 247 */           t.insert(1, (CharSequence)(AD.cityDivs().attachedArmy(div)).name);
/* 248 */           text.textL((CharSequence)t);
/*     */           
/* 250 */           if (AD.cityDivs().daysToReturn(div) > 0.0D) {
/* 251 */             t = text.text();
/* 252 */             t.add(¤¤SoldierReturn);
/* 253 */             t.insert(0, AD.cityDivs().daysToReturn(div), 1);
/* 254 */             text.textL((CharSequence)t);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */