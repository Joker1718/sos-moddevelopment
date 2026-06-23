/*     */ package game.event.actions;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.tmp.TmpBoostSpec;
/*     */ import game.event.engine.EChoice;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*     */   private final TmpBoostSpec spec;
/*     */   private LIST<HCLASS_RACE> pops;
/*     */   private final boolean player;
/*     */   private final boolean regions;
/*     */   private final boolean factions;
/*     */   private final boolean royalties;
/*     */   
/*     */   Imp(String key, Event parent, EChoice choice, Json data, LISTE<EventAction> all) {
/*  62 */     super(key, all);
/*     */     
/*  64 */     String k = "EVENT_" + parent.key;
/*  65 */     if (choice != null)
/*  66 */       k = k + k; 
/*  67 */     this.spec = new TmpBoostSpec(k, parent.info.name, parent.info.desc, parent.info.icon);
/*  68 */     this.spec.spec.read(data, BValue.VALUE1);
/*  69 */     this.pops = HCLASS_RACE.MAP().readManyWarn(data);
/*  70 */     this.player = data.bool("BOOST_ONLY_PLAYER", false);
/*  71 */     this.regions = data.bool("USE_SELECTION_REGIONS", true);
/*  72 */     this.factions = data.bool("USE_SELECTION_FACTIONS", true);
/*  73 */     this.royalties = data.bool("USE_SELECTION_ROYALTIES", true);
/*  74 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event e, EContext data) {
/*  80 */     if (this.player) {
/*  81 */       (GAME.BOOST()).factions.set((INDEXED)FACTIONS.player(), this.spec, true);
/*     */       
/*     */       return;
/*     */     } 
/*  85 */     if (this.regions && data.regs.am > 0) {
/*  86 */       for (Region reg : WORLD.REGIONS().active()) {
/*  87 */         if ((RD.event()).ii.get(reg) == 1) {
/*  88 */           (GAME.BOOST()).regions.set((INDEXED)reg, this.spec, true);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  93 */     if (this.factions && data.faction.am > 0) {
/*  94 */       for (Faction f : FACTIONS.active()) {
/*  95 */         if (f.event()) {
/*  96 */           (GAME.BOOST()).factions.set((INDEXED)f, this.spec, true);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 101 */     if (this.royalties && data.royalty.am > 0) {
/* 102 */       for (FactionNPC f : FACTIONS.NPCs()) {
/* 103 */         for (Royalty roy : f.court().all()) {
/* 104 */           if (roy.event()) {
/* 105 */             (GAME.BOOST()).factions.set((INDEXED)f, this.spec, true);
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 114 */     for (HCLASS_RACE p : this.pops) {
/* 115 */       (GAME.BOOST()).popcl.set((INDEXED)p, this.spec, true);
/*     */     }
/*     */ 
/*     */     
/* 119 */     super.exe(e, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, final EContext context, RECTANGLE messBody) {
/* 131 */     if (!this.player && this.pops.size() > 0) {
/* 132 */       rows.add(new GHeader(_BOOST_PERM.¤¤sTitle, (UI.FONT()).S));
/* 133 */       for (HCLASS_RACE p : this.pops) {
/* 134 */         rows.add((new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 137 */                 text.add(p.race.info.names);
/* 138 */                 text.s();
/* 139 */                 text.add('(');
/* 140 */                 text.add(p.cl.names);
/* 141 */                 text.add(')');
/*     */               }
/* 144 */             }).hh((SPRITE)(p.race.appearance()).icon));
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     if (!this.player && context.regs.am > 0) {
/* 149 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 153 */               GFORMAT.i(text, context.regs.am);
/*     */             }
/* 155 */           }).hh(_BOOST_PERM.¤¤sTitleR));
/*     */     }
/*     */ 
/*     */     
/* 159 */     if (!this.player && context.faction.am > 0) {
/* 160 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 164 */               GFORMAT.i(text, context.faction.am);
/*     */             }
/* 166 */           }).hh(_BOOST_PERM.¤¤sTitleF));
/*     */     }
/*     */ 
/*     */     
/* 170 */     GRows rr = (new GRows(6)).setMin(100);
/*     */     
/* 172 */     for (BoostSpec s : this.spec.spec.all()) {
/* 173 */       rr.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 177 */               if (s.booster.isMul) {
/* 178 */                 text.add('*').s();
/* 179 */                 GFORMAT.f1(text, s.booster.to());
/*     */               } else {
/* 181 */                 GFORMAT.f0(text, s.booster.to());
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 186 */           }).hh((SPRITE)s.boostable.icon));
/*     */     } 
/*     */     
/* 189 */     rows.add((Iterable)rr.rows());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST_PERM$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */