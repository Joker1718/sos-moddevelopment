/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FResources;
/*     */ import game.faction.player.PCredits;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HGROUP;
/*     */ import java.io.Serializable;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class YearlyFinansials
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  37 */   private static CharSequence ¤¤title = "Yearly Report";
/*  38 */   private static CharSequence ¤¤in = "in";
/*  39 */   private static CharSequence ¤¤out = "out";
/*  40 */   private static CharSequence ¤¤profits = "net";
/*     */   static {
/*  42 */     D.ts(YearlyFinansials.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final Data[] all;
/*     */ 
/*     */   
/*     */   public YearlyFinansials() {
/*  50 */     super(¤¤title);
/*     */     
/*  52 */     ArrayListGrower<Data> all = new ArrayListGrower(); byte b; int j;
/*     */     FCredits.CTYPE[] arrayOfCTYPE;
/*  54 */     for (j = (arrayOfCTYPE = FCredits.CTYPE.values()).length, b = 0; b < j; ) { FCredits.CTYPE t = arrayOfCTYPE[b];
/*  55 */       Data data = new Data((SPRITE)(UI.icons()).s.money, String.valueOf(Dic.¤¤Curr) + " " + String.valueOf(Dic.¤¤Curr), (FACTIONS.player().credits().get(t)).yearly);
/*  56 */       if (data.active())
/*  57 */         all.add(data); 
/*     */       b++; }
/*     */     
/*  60 */     Data d = new Data((SPRITE)(UI.icons()).s.money, String.valueOf(Dic.¤¤Curr) + " " + String.valueOf(Dic.¤¤Curr), (FACTIONS.player().credits()).yearly);
/*  61 */     if (d.active()) {
/*  62 */       all.add(d);
/*     */     }
/*  64 */     for (TRADABLE t : TR.ALL()) {
/*  65 */       d = new Data(t);
/*  66 */       if (d.active()) {
/*  67 */         all.add(d);
/*     */       }
/*     */     } 
/*  70 */     for (HGROUP h : HGROUP.all()) {
/*  71 */       d = new Data(h);
/*  72 */       if (d.active()) {
/*  73 */         all.add(d);
/*     */       }
/*     */     } 
/*  76 */     this.all = new Data[all.size()];
/*     */     
/*  78 */     for (int i = 0; i < all.size(); i++) {
/*  79 */       this.all[i] = (Data)all.get(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  87 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  91 */           return YearlyFinansials.this.all.length;
/*     */         }
/*     */       };
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
/* 109 */     bu.column("", 200, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 113 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 117 */                   text.lablify();
/* 118 */                   text.add(((YearlyFinansials.null.access$0(YearlyFinansials.null.this)).all[((Integer)ier.get()).intValue()]).name);
/*     */                 }
/* 120 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 125 */     bu.column(¤¤in, 80, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 129 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 133 */                   GFORMAT.i(text, ((YearlyFinansials.null.access$0(YearlyFinansials.null.this)).all[((Integer)ier.get()).intValue()]).in);
/*     */                 }
/* 135 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 140 */     bu.column(¤¤out, 80, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 144 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 148 */                   GFORMAT.i(text, ((YearlyFinansials.null.access$0(YearlyFinansials.null.this)).all[((Integer)ier.get()).intValue()]).out);
/*     */                 }
/* 150 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 155 */     bu.column(¤¤profits, 80, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 159 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 163 */                   GFORMAT.iIncr(text, (((YearlyFinansials.null.access$0(YearlyFinansials.null.this)).all[((Integer)ier.get()).intValue()]).in + ((YearlyFinansials.null.access$0(YearlyFinansials.null.this)).all[((Integer)ier.get()).intValue()]).out));
/*     */                 }
/* 165 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 171 */     section.add((RENDEROBJ)bu.create(10, true));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Data
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 181 */     int in = 0;
/* 182 */     int out = 0;
/*     */     
/*     */     private final String name;
/*     */     
/*     */     Data(SPRITE icon, CharSequence name, PCredits.Yearly h) {
/* 187 */       this.name = String.valueOf(name);
/*     */       
/* 189 */       int yy = 1;
/*     */       
/* 191 */       this.in = h.PROFITS.get(yy);
/* 192 */       this.out = h.LOSSES.get(yy);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Data(TRADABLE tr) {
/* 198 */       this.name = String.valueOf(tr.names);
/*     */       
/* 200 */       int year = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */       
/* 202 */       for (FResources.RTYPE t : FResources.RTYPE.all) {
/* 203 */         this.in += FACTIONS.player().res().in(t).history(tr).getPeriodSum(-year, 0);
/* 204 */         this.out -= FACTIONS.player().res().out(t).history(tr).getPeriodSum(-year, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Data(HGROUP h) {
/* 211 */       this.name = h.name;
/*     */       
/* 213 */       int year = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */       
/* 215 */       int ii = (STATS.POP()).POP.data(h.type).get(h.race, 0) - (STATS.POP()).POP.data(h.type).get(h.race, year);
/* 216 */       if (ii < 0) {
/* 217 */         this.out += -ii;
/*     */       } else {
/* 219 */         this.in += ii;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean active() {
/* 225 */       return !(this.in == 0 && this.out == 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\YearlyFinansials.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */