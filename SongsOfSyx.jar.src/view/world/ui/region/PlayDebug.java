/*     */ package view.world.ui.region;
/*     */ import game.GAME;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.boosting.tmp.TmpBoostSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import view.ui.util.UIValues;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuildPoints;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ class PlayDebug extends GuiSection {
/*     */   PlayDebug() {
/*  33 */     for (RDBuildPoints.RDBuildPoint p : (RD.BUILDINGS()).costs.ALL) {
/*  34 */       padd((RENDEROBJ)new GButt.ButtPanel(p.bo.name)
/*     */           {
/*     */             
/*     */             protected void clickA()
/*     */             {
/*  39 */               (new RBooster(new BSourceInfo("cheat", null), 0.0D, 2500.0D, false) {
/*  40 */                   final Region rr = (PlayDebug.null.access$0(PlayDebug.null.this)).reg;
/*     */ 
/*     */                   
/*     */                   protected double get(Region reg) {
/*  44 */                     return ((reg == this.rr) ? true : false);
/*     */                   }
/*  48 */                 }).add(p.bo);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     padd((RENDEROBJ)new GButt.Checkbox("claim")
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  60 */             selectedSet((RD.REALM(PlayDebug.this.reg) == RD.REALM((Faction)FACTIONS.player())));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  65 */             if (PlayDebug.this.reg.capitol()) {
/*  66 */               FACTIONS.remove((FactionNPC)PlayDebug.this.reg.faction(), true);
/*     */             }
/*     */             
/*  69 */             RD.setFaction(PlayDebug.this.reg, selectedIs() ? null : (Faction)FACTIONS.player(), true);
/*     */           }
/*     */         });
/*     */     
/*  73 */     padd((RENDEROBJ)new GButt.ButtPanel("affiliate")
/*     */         {
/*     */           protected void clickA() {
/*  76 */             (RD.OWNER()).affiliation.setD(PlayDebug.this.reg, 1.0D);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  81 */     GuiSection s = new GuiSection();
/*  82 */     s.add((SPRITE)new GText((UI.FONT()).S, "devastation"), 0, 0);
/*  83 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/*  87 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/*  92 */           return (RD.DEVASTATION()).current.max(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/*  97 */           return (RD.DEVASTATION()).current.get(PlayDebug.this.reg);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 102 */           (RD.DEVASTATION()).current.set(PlayDebug.this.reg, t);
/*     */         }
/*     */       };
/*     */     
/* 106 */     s.addRightC(8, (RENDEROBJ)new GSliderInt(ii, 100, false));
/* 107 */     padd((RENDEROBJ)s);
/*     */ 
/*     */     
/* 110 */     padd((RENDEROBJ)new GButt.ButtPanel("garrison")
/*     */         {
/*     */           protected void clickA() {
/* 113 */             (RD.MILITARY()).garrison.inc(PlayDebug.this.reg, 50);
/*     */           }
/*     */         });
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
/* 126 */     padd((RENDEROBJ)new GButt.ButtPanel("build")
/*     */         {
/*     */           protected void clickA() {
/* 129 */             RD.UPDATER().BUILD(PlayDebug.this.reg);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     padd((RENDEROBJ)new GButt.ButtPanel("boost")
/*     */         {
/*     */           TmpBoostSpec s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 146 */             (GAME.BOOST()).regions.toggle((INDEXED)PlayDebug.this.reg, this.s);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 151 */     padd((RENDEROBJ)new GButt.ButtPanel("pop ini")
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 155 */             for (RDRace rr : (RD.RACES()).all) {
/* 156 */               rr.pop.init(PlayDebug.this.reg);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 161 */     padd((RENDEROBJ)new GButt.ButtPanel("pop clear")
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 166 */             for (RDRace r : (RD.RACES()).all) {
/* 167 */               r.pop.set(PlayDebug.this.reg, 0);
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 173 */     padd((RENDEROBJ)UIValues.butt(GVALUES.REGION, new GETTER<Region>()
/*     */           {
/*     */             public Region get()
/*     */             {
/* 177 */               return PlayDebug.this.reg;
/*     */             }
/*     */           }));
/*     */ 
/*     */     
/* 182 */     for (RDRace r : (RD.RACES()).all) {
/* 183 */       padd((RENDEROBJ)new GButt.ButtPanel(String.valueOf(r.race) + "++")
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 187 */               r.pop.inc(PlayDebug.this.reg, 100);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   Region reg;
/*     */   
/*     */   void padd(RENDEROBJ o) {
/* 195 */     if (getLastX2() > 600) {
/* 196 */       add(o, 0, body().y2());
/*     */     } else {
/* 198 */       addRightC(0, o);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayDebug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */