/*     */ package game.event.actions;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.event.engine.EChoice;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.event.engine.EventCollection;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class _BOOST extends EventActionConstructor {
/*  46 */   public final ArrayListGrower<Imp> boosts = new ArrayListGrower();
/*  47 */   private static CharSequence ¤¤sTitle = "Boosted Subjects";
/*  48 */   private static CharSequence ¤¤sTitleR = "Boosted Regions";
/*     */   
/*     */   static {
/*  51 */     D.ts(_BOOST.class);
/*     */   }
/*     */   
/*     */   _BOOST() {
/*  55 */     super("BOOST");
/*     */   }
/*     */ 
/*     */   
/*     */   public EventAction action(EventActionConstructor.Data data) {
/*  60 */     return new Imp(this.key, data.parent, data.choice, data.json, data.all);
/*     */   }
/*     */   
/*     */   public final class Imp
/*     */     extends EventAction {
/*  65 */     public final BoostSpecs player = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*  66 */     public final BoostSpecs subjects = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*  67 */     public final BoostSpecs regions = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*     */     public final Event parent;
/*     */     public final EChoice choice;
/*     */     
/*     */     Imp(String key, Event parent, EChoice choice, Json data, LISTE<EventAction> all) {
/*  72 */       super(key, all);
/*  73 */       this.parent = parent;
/*  74 */       this.player.read("PLAYER", data, BValue.VALUE1);
/*  75 */       this.subjects.read("SUBJECTS", data, BValue.VALUE1);
/*  76 */       this.regions.read("REGIONS", data, BValue.VALUE1);
/*  77 */       this.choice = choice;
/*  78 */       _BOOST.this.boosts.add(this);
/*  79 */       data.checkUnused();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox b, Event event, EContext context) {
/*  86 */       if (this.player.all().size() > 0) {
/*  87 */         this.player.hover((GUI_BOX)b, 1.0D, Dic.¤¤Boosts, -1);
/*     */       }
/*  89 */       if (this.subjects.all().size() > 0) {
/*  90 */         b.textLL(_BOOST.¤¤sTitle);
/*  91 */         b.add((SPRITE)GFORMAT.i(b.text(), STATS.EVENT().stat().data().get(null)));
/*  92 */         this.subjects.hover((GUI_BOX)b, 1.0D, null, -1);
/*     */       } 
/*  94 */       if (this.regions.all().size() > 0) {
/*  95 */         b.textLL(_BOOST.¤¤sTitleR);
/*  96 */         b.add((SPRITE)GFORMAT.i(b.text(), STATS.EVENT().stat().data().get(null)));
/*  97 */         this.regions.hover((GUI_BOX)b, 1.0D, null, -1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, final EContext context, RECTANGLE messBody) {
/* 103 */       GRows rr = (new GRows(6)).setMin(100);
/* 104 */       if (this.player.all().size() > 0) {
/* 105 */         rows.add(new GHeader(Dic.¤¤Boosts, (UI.FONT()).S));
/* 106 */         for (BoostSpec s : this.player.all()) {
/* 107 */           rr.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 110 */                   s.booster.format(text, s.booster.getValue(1.0D));
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 115 */                   s.boostable.hover((GUI_BOX)b);
/*     */                 }
/* 118 */               }).hh((SPRITE)s.boostable.icon));
/*     */         } 
/* 120 */         rows.add((Iterable)rr.rows());
/* 121 */         rr = (new GRows(6)).setMin(100);
/*     */       } 
/*     */       
/* 124 */       if (this.subjects.all().size() > 0 && context.indu.am > 0) {
/* 125 */         rows.add((new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 129 */                 GFORMAT.i(text, context.indu.am);
/*     */               }
/* 131 */             }).hh(_BOOST.¤¤sTitle));
/*     */         
/* 133 */         for (BoostSpec s : this.subjects.all()) {
/* 134 */           rr.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 137 */                   s.booster.format(text, s.booster.getValue(1.0D));
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 142 */                   s.boostable.hover((GUI_BOX)b);
/*     */                 }
/* 145 */               }).hh((SPRITE)s.boostable.icon));
/*     */         } 
/* 147 */         rows.add((Iterable)rr.rows());
/* 148 */         rr = (new GRows(6)).setMin(100);
/*     */       } 
/*     */       
/* 151 */       if (this.regions.all().size() > 0 && context.regs.am > 0) {
/* 152 */         rows.add((new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 156 */                 GFORMAT.i(text, context.regs.am);
/*     */               }
/* 158 */             }).hh(_BOOST.¤¤sTitleR));
/*     */         
/* 160 */         for (BoostSpec s : this.regions.all()) {
/* 161 */           rr.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 164 */                   s.booster.format(text, s.booster.getValue(1.0D));
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 169 */                   s.boostable.hover((GUI_BOX)b);
/*     */                 }
/* 172 */               }).hh((SPRITE)s.boostable.icon));
/*     */         } 
/* 174 */         rows.add((Iterable)rr.rows());
/* 175 */         rr = (new GRows(6)).setMin(100);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static void init(final EventCollection handler) {
/* 181 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 185 */             KeyMap<_BOOST.Cluster> map = new KeyMap();
/* 186 */             for (Event e : handler.all) {
/* 187 */               for (EventAction a : e.actions()) {
/* 188 */                 if (a instanceof _BOOST.Imp) {
/* 189 */                   _BOOST.Imp b = (_BOOST.Imp)a;
/* 190 */                   for (BoostSpec s : new ArrayList((Iterable)b.player.all())) {
/* 191 */                     String k = s.boostable.key() + s.boostable.key();
/* 192 */                     if (!map.containsKey(k))
/* 193 */                       map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 194 */                     ((_BOOST.Cluster)map.get(k)).addA(b);
/*     */                   } 
/* 196 */                   for (BoostSpec s : new ArrayList((Iterable)b.subjects.all())) {
/* 197 */                     String k = s.boostable.key() + s.boostable.key();
/* 198 */                     if (!map.containsKey(k))
/* 199 */                       map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 200 */                     ((_BOOST.Cluster)map.get(k)).addB(b);
/*     */                   } 
/* 202 */                   for (BoostSpec s : new ArrayList((Iterable)b.regions.all())) {
/* 203 */                     String k = s.boostable.key() + s.boostable.key();
/* 204 */                     if (!map.containsKey(k))
/* 205 */                       map.put(k, new _BOOST.Cluster(s.boostable, s.booster.isMul)); 
/* 206 */                     ((_BOOST.Cluster)map.get(k)).addC(b);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 215 */             for (_BOOST.Cluster c : map.all())
/*     */             {
/* 217 */               c.add(c.target);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Cluster
/*     */     extends Booster
/*     */     implements BValue
/*     */   {
/* 230 */     private int upI = -1;
/* 231 */     private final ArrayListGrower<_BOOST.ClusterEntry> bplayer = new ArrayListGrower();
/* 232 */     private final ArrayListGrower<_BOOST.ClusterEntry> bregion = new ArrayListGrower();
/* 233 */     private final ArrayListGrower<_BOOST.ClusterEntry> bindu = new ArrayListGrower();
/*     */     
/*     */     private double player;
/*     */     
/*     */     private double reg;
/*     */     private double indu;
/* 239 */     private double from = 0.0D;
/* 240 */     private double to = 0.0D;
/*     */     private final double def;
/*     */     private final Boostable target;
/*     */     
/*     */     public Cluster(Boostable target, boolean isMul) {
/* 245 */       super(new BSourceInfo(Dic.¤¤Event, (SPRITE)(UI.icons()).s.time), isMul);
/* 246 */       if (isMul) {
/* 247 */         this.from = 1.0D;
/* 248 */         this.to = 1.0D;
/* 249 */         this.def = 1.0D;
/*     */       } else {
/* 251 */         this.def = 0.0D;
/*     */       } 
/* 253 */       this.target = target;
/*     */     }
/*     */     
/*     */     void addA(_BOOST.Imp b) {
/* 257 */       for (BoostSpec s : b.player.all()) {
/* 258 */         if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 259 */           add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bplayer);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void addB(_BOOST.Imp b) {
/* 265 */       for (BoostSpec s : b.subjects.all()) {
/* 266 */         if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 267 */           add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bindu);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void addC(_BOOST.Imp b) {
/* 273 */       for (BoostSpec s : b.regions.all()) {
/* 274 */         if (s.boostable == this.target && s.booster.isMul == this.isMul) {
/* 275 */           add(new _BOOST.ClusterEntry(b, s.booster.to()), this.bregion);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void add(_BOOST.ClusterEntry b, ArrayListGrower<_BOOST.ClusterEntry> li) {
/* 282 */       li.add(b);
/*     */       
/* 284 */       if ((this.isMul && b.value < 1.0D) || b.value < 0.0D) {
/* 285 */         this.from = Math.min(this.from, b.value);
/*     */       } else {
/* 287 */         this.to = Math.max(this.to, b.value);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void cache() {
/* 293 */       if (this.upI == GAME.updateI())
/*     */         return; 
/* 295 */       this.upI = GAME.updateI();
/* 296 */       this.player = this.def;
/* 297 */       this.indu = this.def;
/* 298 */       this.reg = this.def;
/*     */       
/* 300 */       if (this.isMul) {
/* 301 */         for (_BOOST.ClusterEntry e : this.bplayer) {
/* 302 */           if (isActive(e)) {
/* 303 */             this.player *= e.value;
/*     */           }
/*     */         } 
/*     */         
/* 307 */         for (_BOOST.ClusterEntry e : this.bindu) {
/* 308 */           if (isActive(e)) {
/* 309 */             this.indu *= e.value;
/*     */           }
/*     */         } 
/*     */         
/* 313 */         for (_BOOST.ClusterEntry e : this.bregion) {
/* 314 */           if (isActive(e)) {
/* 315 */             this.reg *= e.value;
/*     */           }
/*     */         } 
/*     */         
/* 319 */         this.indu = this.indu * this.player - this.player;
/* 320 */         this.reg = this.reg * this.player - this.player;
/*     */       } else {
/*     */         
/* 323 */         for (_BOOST.ClusterEntry e : this.bplayer) {
/* 324 */           if (isActive(e)) {
/* 325 */             this.player += e.value;
/*     */           }
/*     */         } 
/* 328 */         for (_BOOST.ClusterEntry e : this.bregion) {
/* 329 */           if (isActive(e)) {
/* 330 */             this.reg += e.value;
/*     */           }
/*     */         } 
/* 333 */         for (_BOOST.ClusterEntry e : this.bindu) {
/* 334 */           if (isActive(e))
/* 335 */             this.indu += e.value; 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean isActive(_BOOST.ClusterEntry e) {
/* 341 */       if (e.imp.choice == null)
/* 342 */         return (GAME.EVENT().current() == e.imp.parent); 
/* 343 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 348 */       return input;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(BOOSTABLE_O o) {
/* 353 */       return o.boostableValue(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/* 358 */       if (f == FACTIONS.player())
/* 359 */         return vGet(HCLASS_RACE.clP()); 
/* 360 */       return this.def;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 365 */       cache();
/* 366 */       return this.player + (((RD.event()).ii.get(reg) == 1) ? this.reg : 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 371 */       cache();
/* 372 */       return this.player + (STATS.EVENT().has(indu) ? this.indu : 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 377 */       if (div.army().faction() == FACTIONS.player()) {
/* 378 */         cache();
/* 379 */         return this.player + STATS.EVENT().stat().div().getD(div) * this.indu;
/*     */       } 
/* 381 */       return this.def;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE popTime) {
/* 386 */       cache();
/* 387 */       return this.player + STATS.EVENT().stat().data(popTime.cl).getD(popTime.race) * this.indu;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 392 */       cache();
/* 393 */       return this.player;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 398 */       return this.def;
/*     */     }
/*     */ 
/*     */     
/*     */     public double from() {
/* 403 */       return this.from;
/*     */     }
/*     */ 
/*     */     
/*     */     public double to() {
/* 408 */       return this.to;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ClusterEntry
/*     */   {
/*     */     private final _BOOST.Imp imp;
/*     */     
/*     */     private final double value;
/*     */ 
/*     */     
/*     */     ClusterEntry(_BOOST.Imp imp, double value) {
/* 421 */       this.imp = imp;
/* 422 */       this.value = value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */