/*     */ package game.event.actions;
/*     */ 
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.RMAP;
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
/*     */ 
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*     */   private final CAUSE_LEAVE cause;
/*     */   private final boolean damage;
/*     */   private final boolean useSelection;
/*     */   private final int selectionFrom;
/*     */   private final int selectionTo;
/*  57 */   private final ArrayListGrower<_SUBJECTS_KILL.RAmount> datas = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   Imp(String key, Json data, LISTE<EventAction> all) {
/*  61 */     super(key, all);
/*  62 */     this.cause = (CAUSE_LEAVE)CAUSE_LEAVES.MAP().read("DEATH_CAUSE", data);
/*  63 */     RACES.map().getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     this.damage = data.bool("DAMAGE", false);
/*  73 */     this.useSelection = data.bool("USE_SELECTION", false);
/*  74 */     this.selectionFrom = data.i("SELECTION_FROM", 0, 2147483647, 0);
/*  75 */     this.selectionTo = data.i("SELECTION_FROM", 0, this.selectionFrom, 2147483647);
/*  76 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContext(Event event, EContext data) {
/*  81 */     for (_SUBJECTS_KILL.RAmount d : this.datas) {
/*  82 */       if (!this.useSelection)
/*     */       {
/*     */         
/*  85 */         d.set(event, data, (STATS.POP()).POP.data().get(d.t));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event event, EContext data) {
/*  95 */     ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/*     */     
/*  97 */     int[] ams = Alloc.ii(RACES.all().size());
/*  98 */     for (_SUBJECTS_KILL.RAmount a : this.datas) {
/*  99 */       ams[a.t.index()] = ams[a.t.index()] + a.amount.get(event, data);
/*     */     }
/*     */     
/* 102 */     int si = 0;
/* 103 */     for (int ie = 0; ie < ee.length; ie++) {
/* 104 */       ENTITY e = ee[ie];
/* 105 */       if (e instanceof Humanoid) {
/*     */ 
/*     */         
/* 108 */         Humanoid a = (Humanoid)e;
/*     */         
/* 110 */         if (this.useSelection) {
/* 111 */           if (STATS.EVENT().has(a.indu())) {
/* 112 */             if (si >= this.selectionFrom && si < this.selectionTo) {
/* 113 */               _SUBJECTS_KILL.slap(data, e, (this.damage ? true : false), this.cause);
/*     */             }
/* 115 */             ie--;
/* 116 */             si++;
/*     */           }
/*     */         
/*     */         }
/* 120 */         else if (ams[(a.race()).index] > 0) {
/* 121 */           _SUBJECTS_KILL.slap(data, e, (this.damage ? true : false), this.cause);
/* 122 */           ams[(a.race()).index] = ams[(a.race()).index] - 1;
/* 123 */           ie--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, final Event event, final EContext data, RECTANGLE messBody) {
/* 132 */     GRows rr = (new GRows(6)).setMin(100);
/* 133 */     if (this.useSelection) {
/*     */       
/* 135 */       for (HCLASS_RACE c : HCLASS_RACE.ALL()) {
/* 136 */         if (c.race != null && c.cl != null) {
/* 137 */           final int am = STATS.EVENT().stat().data(c.cl).get(c.race);
/* 138 */           if (am > 0) {
/* 139 */             rr.add((RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 143 */                     GFORMAT.i(text, -am);
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void hoverInfoGet(GBox b) {
/* 148 */                     b.title((CharSequence)b.text().add(c.race.info.names).s().add('(').add(c.cl.names).add(')'));
/* 149 */                     b.add((SPRITE)GFORMAT.i(b.text(), -am));
/* 150 */                     b.NL();
/*     */                   }
/* 154 */                 }).hh((SPRITE)(c.race.appearance()).icon.twin((SPRITE)(UI.icons()).s.death, DIR.NE, 1)));
/*     */           }
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 161 */       for (_SUBJECTS_KILL.RAmount d : this.datas) {
/*     */         
/* 163 */         rr.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 167 */                 GFORMAT.i(text, -d.amount.get(event, data));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 172 */                 b.title((CharSequence)b.text().add(d.t.info.names));
/* 173 */                 b.add((SPRITE)GFORMAT.i(b.text(), -d.amount.get(event, data)));
/* 174 */                 b.NL();
/*     */               }
/* 178 */             }).hh((SPRITE)(d.t.appearance()).icon.twin((SPRITE)(UI.icons()).s.death, DIR.NE, 1)));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 183 */     rows.add((Iterable)rr.rows());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/* 189 */     int t = 0;
/* 190 */     if (this.useSelection) {
/* 191 */       for (HCLASS_RACE c : HCLASS_RACE.ALL()) {
/* 192 */         if (c.race != null && c.cl != null) {
/* 193 */           int am = STATS.EVENT().stat().data(c.cl).get(c.race);
/* 194 */           if (am > 0) {
/* 195 */             if (t > 5) {
/* 196 */               t = 0;
/* 197 */               b.NL();
/*     */             } 
/* 199 */             b.tab(t * 3);
/* 200 */             t++;
/* 201 */             b.add((SPRITE)(c.race.appearance()).icon);
/* 202 */             b.add((SPRITE)GFORMAT.i(b.text(), -am));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 208 */       for (_SUBJECTS_KILL.RAmount d : this.datas) {
/*     */         
/* 210 */         if (t > 5) {
/* 211 */           t = 0;
/* 212 */           b.NL();
/*     */         } 
/* 214 */         b.tab(t * 3);
/* 215 */         t++;
/* 216 */         b.add((SPRITE)(d.t.appearance()).icon);
/* 217 */         b.add((SPRITE)GFORMAT.i(b.text(), -d.amount.get(event, context)));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SUBJECTS_KILL$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */