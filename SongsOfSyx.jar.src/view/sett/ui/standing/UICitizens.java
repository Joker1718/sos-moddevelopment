/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class UICitizens
/*     */   extends ISidePanel
/*     */ {
/*  31 */   private final GETTER.GETTER_IMP<Race> race = new GETTER.GETTER_IMP();
/*     */   private final Cats cats;
/*  33 */   private static CharSequence ¤¤all = "¤All";
/*     */ 
/*     */   
/*     */   public UICitizens(HCLASS cl) {
/*  37 */     D.t(this);
/*  38 */     this.cats = new Cats(cl, (GETTER<Race>)this.race);
/*  39 */     titleSet(cl.names);
/*  40 */     this.section.add((RENDEROBJ)new CitizenMain(cl, (GETTER<Race>)this.race, HEIGHT, this.cats));
/*  41 */     this.section.addRelBody(8, DIR.W, makeList(¤¤all, cl));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ makeList(CharSequence ¤¤all, final HCLASS cl) {
/*  47 */     RENDEROBJ[] rens = new RENDEROBJ[RACES.all().size() + 1];
/*  48 */     int i = 0;
/*     */     
/*  50 */     GButt.BSection bSection = new GButt.BSection()
/*     */       {
/*     */         protected void clickA() {
/*  53 */           UICitizens.this.race.set(null);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  58 */           selectedSet((UICitizens.this.race.get() == null));
/*     */         }
/*     */       };
/*  61 */     bSection.body().incrW(64.0D);
/*  62 */     GHeader h = new GHeader(¤¤all);
/*  63 */     h.body().centerIn((BODY_HOLDER)bSection);
/*  64 */     bSection.add((RENDEROBJ)h);
/*  65 */     DOUBLE d = new DOUBLE()
/*     */       {
/*     */         public double getD()
/*     */         {
/*  69 */           return (STANDINGS.get(cl)).loyalty.getD(null);
/*     */         }
/*     */       };
/*  72 */     bSection.addDownC(2, GMeter.sprite(GMeter.C_REDGREEN, d, bSection.body().width(), 16));
/*  73 */     bSection.addDownC(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  77 */             GFORMAT.i(text, POP.tot(cl, null));
/*     */           }
/*  79 */         }).decrease().r(DIR.C));
/*     */     
/*  81 */     bSection.pad(4);
/*     */     
/*  83 */     rens[i++] = (RENDEROBJ)bSection;
/*     */ 
/*     */ 
/*     */     
/*  87 */     for (int ii = 0; ii < RACES.all().size(); ii++) {
/*  88 */       final int ri = ii;
/*  89 */       GButt.BSection s = new GButt.BSection()
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  93 */             UICitizens.this.race.set((FACTIONS.player()).races.get(ri));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  98 */             selectedSet((UICitizens.this.race.get() == (FACTIONS.player()).races.get(ri)));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 103 */             text.title(((FACTIONS.player()).races.get(ri)).info.names);
/* 104 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 108 */       s.add((SPRITE)new SPRITE.Imp(64, 64)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 112 */               ((FACTIONS.player()).races.get(ri).appearance()).iconBig.render(r, X1, X2, Y1, Y2);
/*     */             }
/* 114 */           }0, 0);
/* 115 */       DOUBLE dOUBLE = new DOUBLE()
/*     */         {
/*     */           public double getD()
/*     */           {
/* 119 */             return (STANDINGS.get(cl)).loyalty.getD((FACTIONS.player()).races.get(ri));
/*     */           }
/*     */         };
/* 122 */       s.addDown(2, GMeter.sprite(GMeter.C_REDGREEN, dOUBLE, s.body().width(), 16));
/* 123 */       s.addDownC(2, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 127 */               GFORMAT.i(text, POP.tot(cl, (FACTIONS.player()).races.get(ri)));
/*     */             }
/* 129 */           }).decrease().r(DIR.C));
/* 130 */       s.pad(4);
/*     */       
/* 132 */       rens[i++] = (RENDEROBJ)s;
/*     */     } 
/*     */     
/* 135 */     GScrollRows sc = new GScrollRows(rens, HEIGHT, 0);
/* 136 */     return (RENDEROBJ)sc.view();
/*     */   }
/*     */ 
/*     */   
/*     */   public void open(Race res) {
/* 141 */     this.race.set(res);
/* 142 */     (VIEW.s()).panels.add(this, true);
/* 143 */     (VIEW.s()).panels.add((ISidePanel)this.cats.all.get(0), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void openAccess(Race res) {
/* 148 */     this.race.set(res);
/* 149 */     (VIEW.s()).panels.add(this, true);
/* 150 */     (VIEW.s()).panels.add(this.cats.access, false);
/*     */   }
/*     */   
/*     */   public void openEquip(Race res) {
/* 154 */     this.race.set(res);
/* 155 */     (VIEW.s()).panels.add(this, true);
/* 156 */     (VIEW.s()).panels.add(this.cats.access, false);
/*     */   }
/*     */   
/*     */   public boolean equipIs(Race res) {
/* 160 */     return (this.race.get() == res && (VIEW.s()).panels.added(this.cats.access));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\UICitizens.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */