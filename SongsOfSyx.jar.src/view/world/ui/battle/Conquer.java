/*     */ package view.world.ui.battle;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.race.RACES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ class Conquer extends GuiSection {
/*  38 */   private static CharSequence ¤¤name = "¤Region Captured";
/*  39 */   private static CharSequence ¤¤desc = "¤The city of {0} is captured my lord. What shall be the fate of its citizens?";
/*     */ 
/*     */   
/*  42 */   private static CharSequence ¤¤Enslave = "¤Enslave";
/*  43 */   private static CharSequence ¤¤EnslaveD = "¤Line the population up and ship the healthiest specimen to the capitol as slaves";
/*  44 */   private static CharSequence ¤¤Plunder = "¤Plunder";
/*  45 */   private static CharSequence ¤¤Sack = "¤Loot";
/*  46 */   private static CharSequence ¤¤sackD = "¤Grab what we can of valuables.";
/*  47 */   private static CharSequence ¤¤Raze = "¤Raze";
/*  48 */   private static CharSequence ¤¤RazeD = "¤Let your men blow off some steam after a tough siege. Spare none, leave no stone unturned and teach this settlement a lesson that will be remembered for generations.";
/*     */   
/*  50 */   private static CharSequence ¤¤Occupy = "¤Occupy";
/*  51 */   private static CharSequence ¤¤Abandon = "¤Abandon";
/*  52 */   private static CharSequence ¤¤Puppet = "¤Puppet";
/*     */   
/*  54 */   private static CharSequence ¤¤OccupyD = "¤Take full control of this region.";
/*  55 */   private static CharSequence ¤¤AbandonD = "¤Let this settlement find its future on its own.";
/*  56 */   private static CharSequence ¤¤PuppetP = "¤Currently, there are no nobles available that can take on the job of governing the region.";
/*  57 */   private static CharSequence ¤¤PuppetD = "¤Install a puppet regime. A new faction will be created, which will be long indebted to you."; public static final int width = 600;
/*     */   
/*     */   static {
/*  60 */     D.ts(Conquer.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean enslave;
/*     */   
/*     */   private boolean loot;
/*     */   
/*     */   private boolean raze;
/*     */   
/*     */   private final WBattleSiege.Result result;
/*     */   
/*     */   Conquer(final ACTION close, final WBattleSiege.Result result) {
/*  73 */     this.result = result;
/*  74 */     CharSequence[] descs = (UI.FONT()).M.getRows((CharSequence)Str.TMP.clear().add(¤¤desc).insert(0, (CharSequence)result.besiged.info.name()), 600); byte b; int i;
/*     */     CharSequence[] arrayOfCharSequence1;
/*  76 */     for (i = (arrayOfCharSequence1 = descs).length, b = 0; b < i; ) { CharSequence d = arrayOfCharSequence1[b];
/*  77 */       GText t = new GText((UI.FONT()).M, d);
/*  78 */       t.warnify();
/*  79 */       addRelBody(4, DIR.S, (SPRITE)t);
/*     */       
/*     */       b++; }
/*     */     
/*  83 */     GuiSection ss = new GuiSection();
/*     */     
/*  85 */     ss.add((RENDEROBJ)(new GButt.ButtPanel(¤¤Enslave)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  89 */             Conquer.this.enslave = !Conquer.this.enslave;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  94 */             selectedSet(Conquer.this.enslave);
/*     */           }
/*  97 */         }).setDim(150, 30).hoverInfoSet(¤¤EnslaveD));
/*     */     
/*  99 */     ss.addRightC(2, (RENDEROBJ)(new GButt.ButtPanel(¤¤Sack)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 103 */             Conquer.this.loot = !Conquer.this.loot;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 108 */             selectedSet(Conquer.this.loot);
/*     */           }
/* 111 */         }).setDim(150, 30).hoverInfoSet(¤¤sackD));
/*     */     
/* 113 */     ss.addRightC(2, (RENDEROBJ)(new GButt.ButtPanel(¤¤Raze)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 117 */             Conquer.this.raze = !Conquer.this.raze;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 122 */             selectedSet(Conquer.this.raze);
/*     */           }
/* 124 */         }).setDim(150, 30).hoverInfoSet(¤¤RazeD));
/*     */     
/* 126 */     addRelBody(16, DIR.S, (RENDEROBJ)ss);
/*     */ 
/*     */     
/* 129 */     final Slaves slaves = new Slaves();
/* 130 */     addRelBody(16, DIR.S, (RENDEROBJ)slaves);
/*     */     
/* 132 */     final Spoils spoils = new Spoils();
/* 133 */     addRelBody(16, DIR.S, (RENDEROBJ)spoils);
/*     */     
/* 135 */     GuiSection stats = new GuiSection();
/*     */     
/* 137 */     stats.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 141 */             GFORMAT.percInv(text, Conquer.this.deva());
/*     */           }
/* 143 */         }).hh((SPRITE)(UI.icons()).m.repair).hoverTitleSet(((RD.DEVASTATION()).current.info()).name).hoverInfoSet(((RD.DEVASTATION()).current.info()).desc));
/*     */     
/* 145 */     stats.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 149 */             GFORMAT.iIncr(text, -((int)(Conquer.this.death() * (RD.RACES()).population.get(result.besiged))));
/*     */           }
/* 151 */         }).hh((SPRITE)(UI.icons()).m.skull).hoverInfoSet(Dic.¤¤Deaths));
/*     */     
/* 153 */     stats.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 157 */             GFORMAT.f0(text, Conquer.this.mercy());
/*     */           }
/* 159 */         }).hh((SPRITE)(UI.icons()).m.heart).hoverInfoSet((ROPINION.STANCE()).chivalry.info.name));
/*     */     
/* 161 */     addRelBody(16, DIR.S, (RENDEROBJ)stats);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     GuiSection butts = new GuiSection();
/* 167 */     butts.add((RENDEROBJ)(new Battle.Butt((FACTIONS.player().banner()).MEDIUM, ¤¤Occupy)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 171 */             close.exe();
/* 172 */             AD.stats().mercy().incD(FACTIONS.player(), Conquer.this.mercy());
/* 173 */             result.occupy(Conquer.this.deva(), Conquer.this.death(), slaves.accepted(), spoils.accepted());
/*     */           }
/* 176 */         }).hoverInfoSet(¤¤OccupyD));
/*     */     
/* 178 */     butts.addRightC(0, (RENDEROBJ)(new Battle.Butt((SPRITE)(SPRITES.icons()).m.rebellion, ¤¤Abandon)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 182 */             close.exe();
/* 183 */             AD.stats().mercy().incD(FACTIONS.player(), Conquer.this.mercy());
/* 184 */             result.abandon(Conquer.this.deva(), Conquer.this.death(), slaves.accepted(), spoils.accepted());
/*     */           }
/* 187 */         }).hoverInfoSet(¤¤AbandonD));
/*     */     
/* 189 */     butts.addRightC(0, (RENDEROBJ)(new Battle.Butt((SPRITE)(SPRITES.icons()).m.flag, ¤¤Puppet)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 193 */             close.exe();
/*     */             
/* 195 */             AD.stats().mercy().incD(FACTIONS.player(), Conquer.this.mercy());
/* 196 */             result.puppet(Conquer.this.deva(), Conquer.this.deva(), slaves.accepted(), spoils.accepted());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 203 */             activeSet(WBattleSiege.Result.canPuppet());
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 207 */             if (!WBattleSiege.Result.canPuppet()) {
/* 208 */               text.text(Conquer.¤¤PuppetP);
/*     */             } else {
/* 210 */               super.hoverInfoGet(text);
/*     */             } 
/*     */           }
/* 213 */         }).hoverInfoSet(¤¤PuppetD));
/*     */     
/* 215 */     addRelBody(8, DIR.S, (RENDEROBJ)butts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 223 */     super.render(r, ds);
/* 224 */     int w = (UI.FONT()).H2.width(¤¤name);
/* 225 */     (UI.PANEL()).titleBoxes[1].renderCY(r, body().cX() - w / 2, body().y1() - 16, w);
/* 226 */     (GCOLOR.T()).H1.bind();
/* 227 */     (UI.FONT()).H2.renderC(r, body().cX(), body().y1() - 16, ¤¤name);
/* 228 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public double deva() {
/* 232 */     double d = 0.1D;
/* 233 */     if (this.loot)
/* 234 */       d += 0.25D; 
/* 235 */     if (this.raze)
/* 236 */       d = 1.0D; 
/* 237 */     return d;
/*     */   }
/*     */   
/*     */   public double death() {
/* 241 */     double d = 0.1D;
/* 242 */     if (this.enslave)
/* 243 */       d += 0.25D; 
/* 244 */     if (this.loot)
/* 245 */       d += 0.1D; 
/* 246 */     if (this.raze)
/* 247 */       d = 0.95D; 
/* 248 */     return d;
/*     */   }
/*     */   
/*     */   public double mercy() {
/* 252 */     double m = 0.0D;
/*     */     
/* 254 */     if (this.enslave) {
/* 255 */       m -= (RD.RACES()).population.get(this.result.besiged) * 0.25D;
/*     */     }
/* 257 */     if (this.loot) {
/* 258 */       m -= (RD.RACES()).population.get(this.result.besiged) * 0.25D;
/*     */     }
/* 260 */     if (this.raze) {
/* 261 */       m -= (RD.RACES()).population.get(this.result.besiged);
/*     */     }
/*     */     
/* 264 */     m /= (1 + POP.tot(null));
/* 265 */     m = CLAMP.d(m, -5.0D, 5.0D);
/* 266 */     return m;
/*     */   }
/*     */   
/*     */   private class Spoils
/*     */     extends GuiSection
/*     */   {
/*     */     Spoils() {
/* 273 */       int am = 4;
/* 274 */       GRows rows = (new GRows(am)).setMin(100);
/* 275 */       for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/*     */         
/* 277 */         if (res.loot(Conquer.this.result.besiged) > 0)
/*     */         {
/* 279 */           rows.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 283 */                   GFORMAT.i(text, Conquer.Spoils.this.am(res));
/*     */                 }
/* 285 */               }).hh(res.res.icon()));
/*     */         }
/*     */       } 
/*     */       
/* 289 */       add((RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 84)).view());
/*     */       
/* 291 */       addC(GCOLOR.UI().border().makeFrame(body().width() + 8, body().height() + 8, 1), body().cX(), body().cY());
/*     */       
/* 293 */       addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(Conquer.¤¤Plunder));
/*     */     }
/*     */     
/*     */     public int am(RDOutputs.RDResource res) {
/* 297 */       return Conquer.this.loot ? (res.loot(Conquer.this.result.besiged) * 8) : 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int[] accepted() {
/* 302 */       int[] accepted = Alloc.ii(TR.ALL().size());
/* 303 */       for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/* 304 */         accepted[res.res.index()] = accepted[res.res.index()] + am(res);
/*     */       }
/* 306 */       return accepted;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Slaves
/*     */     extends GuiSection
/*     */   {
/*     */     public Slaves() {
/* 316 */       int am = 4;
/* 317 */       GRows rows = (new GRows(am)).setMin(100);
/*     */       
/* 319 */       for (RDRace race : (RD.RACES()).all) {
/*     */         
/* 321 */         if (race.pop.get(Conquer.this.result.besiged) <= 0) {
/*     */           continue;
/*     */         }
/* 324 */         rows.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 328 */                 GFORMAT.i(text, Conquer.Slaves.this.slaves(race));
/*     */               }
/* 330 */             }).hh((SPRITE)(race.race.appearance()).icon));
/*     */       } 
/*     */       
/* 333 */       addRelBody(4, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 48)).view());
/*     */       
/* 335 */       addC(GCOLOR.UI().border().makeFrame(body().width() + 8, body().height() + 8, 1), body().cX(), body().cY());
/*     */       
/* 337 */       addRelBody(8, DIR.N, (RENDEROBJ)new GHeader((HTYPES.PRISONER()).names));
/*     */     }
/*     */ 
/*     */     
/*     */     private int slaves(RDRace race) {
/* 342 */       if (Conquer.this.enslave)
/* 343 */         return (int)(race.pop.get(Conquer.this.result.besiged) * 0.3D); 
/* 344 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int[] accepted() {
/* 349 */       int[] accepted = Alloc.ii(RACES.all().size());
/*     */       
/* 351 */       if (Conquer.this.enslave) {
/* 352 */         for (RDRace race : (RD.RACES()).all) {
/* 353 */           accepted[race.race.index] = slaves(race);
/*     */         }
/*     */       }
/* 356 */       return accepted;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Conquer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */