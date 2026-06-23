/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FWorth;
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import init.trade.TR_STOCKPILE;
/*     */ import java.io.Serializable;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ final class MessDemand extends MessageSection {
/*  43 */   private static CharSequence ¤¤title = "Protection?";
/*  44 */   private static CharSequence ¤¤title2 = "Raider Returns";
/*     */   
/*  46 */   private static CharSequence ¤¤pay = "¤Pay Up";
/*  47 */   private static CharSequence ¤¤decline = "¤Decline Offer";
/*     */   
/*  49 */   private static CharSequence ¤¤proInfo = "¤Our scouts report these people have about {0} soldiers. Paying the sum is a safe bet. Declining might lead to trouble. We have 1 day to decide.";
/*     */   
/*  51 */   private static CharSequence ¤¤nolonger = "You do not have enough goods to meet their demands. ({0})";
/*  52 */   private static CharSequence ¤¤nocreds = "You do not have enough denari to meet their demands."; private static final long serialVersionUID = 1L; private final Demand demand;
/*     */   
/*     */   static {
/*  55 */     D.ts(MessDemand.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final Raider raider;
/*     */   
/*     */   private final String[] mess;
/*     */   private static DEntries ee;
/*     */   
/*     */   public MessDemand(Raider raider) {
/*  65 */     super((raider.raids == 1) ? ¤¤title : ¤¤title2);
/*  66 */     this.raider = raider;
/*     */     
/*  68 */     this.demand = new Demand(raider);
/*     */     
/*  70 */     this.mess = new String[raider.text.demandBody.size()];
/*  71 */     int mi = 0;
/*  72 */     for (String s : raider.text.demandBody) {
/*  73 */       this.mess[mi++] = s;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  80 */     section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*     */     
/*  82 */     LinkedList<RENDEROBJ> rows = new LinkedList(); byte b; int i;
/*     */     String[] arrayOfString;
/*  84 */     for (i = (arrayOfString = this.mess).length, b = 0; b < i; ) { String ss = arrayOfString[b]; byte b1; int j; CharSequence[] arrayOfCharSequence;
/*  85 */       for (j = (arrayOfCharSequence = (UI.FONT()).M.getRows(ss, 900)).length, b1 = 0; b1 < j; ) { CharSequence charSequence = arrayOfCharSequence[b1];
/*  86 */         rows.add(new GTextR((UI.FONT()).M, charSequence)); b1++; }
/*     */       
/*  88 */       rows.add(new RENDEROBJ.RenderDummy(10, 8));
/*     */       
/*     */       b++; }
/*     */     
/*  92 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, C.HEIGHT() - 600)).view());
/*     */ 
/*     */     
/*  95 */     Str s = Str.TMP.clear();
/*  96 */     s.add(¤¤proInfo);
/*  97 */     s.insert(0, this.raider.army.men);
/*     */ 
/*     */ 
/*     */     
/* 101 */     section.addRelBody(16, DIR.S, (SPRITE)(new GText((UI.FONT()).S, String.valueOf(s))).lablifySub().setMaxWidth(900));
/*     */     
/* 103 */     section.addRelBody(16, DIR.S, this.demand.section(true));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Demand
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/* 114 */     private int[] resources = Alloc.ii(TR.ALL().size());
/* 115 */     private int credits = 0;
/*     */     private boolean payed = false;
/*     */     private boolean declined = false;
/*     */     private final int iteration;
/*     */     private final Raider raider;
/*     */     
/*     */     public Demand(Raider raider) {
/* 122 */       this(raider, worth(raider));
/*     */     }
/*     */     
/*     */     private static int worth(Raider raider) {
/* 126 */       int wo = (int)FACTIONS.WORTH().raider();
/* 127 */       wo = (int)Math.max(raider.worth, (wo /= 4));
/* 128 */       wo = (int)Math.min(wo, FACTIONS.WORTH().raider() / 2.0D);
/*     */       
/* 130 */       return wo;
/*     */     }
/*     */     
/*     */     private Demand(Raider raider, double cre) {
/* 134 */       this.iteration = (GAME.raiders()).current.iterration;
/* 135 */       this.raider = raider;
/*     */       
/* 137 */       if (MessDemand.ee == null) {
/* 138 */         MessDemand.ee = new MessDemand.DEntries();
/*     */       }
/* 140 */       MessDemand.ee.set(this, (int)cre);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean canRespond() {
/* 145 */       if (this.payed)
/* 146 */         return false; 
/* 147 */       if (this.declined || !(GAME.raiders()).current.canPay(this.iteration))
/* 148 */         return false; 
/* 149 */       return true;
/*     */     }
/*     */     
/*     */     boolean canPay() {
/* 153 */       if (this.payed)
/* 154 */         return false; 
/* 155 */       if (this.declined || !(GAME.raiders()).current.canPay(this.iteration))
/* 156 */         return false; 
/* 157 */       if (this.credits > 0 && FACTIONS.player().credits().getD() < this.credits)
/* 158 */         return false; 
/* 159 */       for (TRADABLE res : TR.ALL()) {
/* 160 */         if (this.resources[res.index()] > 0 && this.resources[res.index()] > res.ps().playerOwned()) {
/* 161 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 165 */       return true;
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 169 */       GBox b = (GBox)text;
/* 170 */       if (this.credits > 0 && FACTIONS.player().credits().getD() < this.credits) {
/* 171 */         b.error(MessDemand.¤¤nocreds);
/*     */       }
/* 173 */       for (TRADABLE res : TR.ALL()) {
/* 174 */         if (this.resources[res.index()] > 0 && this.resources[res.index()] > res.ps().playerOwned()) {
/* 175 */           Str.TMP.clear().add(MessDemand.¤¤nolonger).insert(0, res.names);
/* 176 */           b.error((CharSequence)Str.TMP);
/* 177 */           b.NL();
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void pay() {
/* 184 */       FACTIONS.player().credits().inc(-this.credits, FCredits.CTYPE.TRIBUTE);
/* 185 */       TR_STOCKPILE stock = new TR_STOCKPILE();
/* 186 */       for (TRADABLE res : TR.ALL()) {
/* 187 */         stock.set(res, this.resources[res.index()]);
/* 188 */         FACTIONS.player().seller(res).remove(this.resources[res.index()], TRADE_TYPE.spoils, 0, null);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public RENDEROBJ section(boolean buttons) {
/* 194 */       GuiSection s = new GuiSection();
/*     */       
/* 196 */       GRows rr = new GRows(7);
/* 197 */       if (this.credits > 0) {
/* 198 */         rr.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 202 */                 GFORMAT.i(text, MessDemand.Demand.this.credits);
/* 203 */                 if (FACTIONS.player().credits().getD() < MessDemand.Demand.this.credits) {
/* 204 */                   text.errorify();
/*     */                 } else {
/* 206 */                   text.normalify();
/*     */                 }  }
/* 208 */             }).hhw((SPRITE)(UI.icons()).m.coins, 64).hoverInfoSet(Dic.¤¤Curr));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 213 */       for (TRADABLE res : TR.ALL()) {
/* 214 */         if (res.index() < this.resources.length && this.resources[res.index()] > 0) {
/* 215 */           rr.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 219 */                   GFORMAT.i(text, MessDemand.Demand.this.resources[res.index()]);
/* 220 */                   if (MessDemand.Demand.this.resources[res.index()] > res.ps().playerOwned()) {
/* 221 */                     text.errorify();
/*     */                   } else {
/* 223 */                     text.normalify();
/*     */                   }  }
/* 225 */               }).hhw(res.icon(), 64).hoverInfoSet(res.name));
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 231 */       if (rr.rows().size() > 2) {
/* 232 */         GScrollRows sr = new GScrollRows((Iterable)rr.rows(), ((RENDEROBJ)rr.rows().get(0)).body().height() * 2);
/* 233 */         s.add((RENDEROBJ)sr.view());
/*     */       } else {
/* 235 */         for (RENDEROBJ o : rr.rows()) {
/* 236 */           s.addRelBody(8, DIR.S, o);
/*     */         }
/*     */       } 
/*     */       
/* 240 */       if (buttons) {
/* 241 */         GuiSection bb = new GuiSection();
/*     */         
/* 243 */         bb.add((RENDEROBJ)new GButt.ButtPanel(MessDemand.¤¤pay)
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 247 */                 activeSet(!expired());
/*     */               }
/*     */ 
/*     */               
/*     */               private boolean expired() {
/* 252 */                 return !(!MessDemand.Demand.this.declined && !MessDemand.Demand.this.payed && (GAME.raiders()).current.canPay(MessDemand.Demand.this.iteration));
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 260 */                 super.render(r, ds, isActive, isSelected, isHovered);
/* 261 */                 if (!expired() && !MessDemand.Demand.this.canPay()) {
/* 262 */                   OPACITY.O50.bind();
/* 263 */                   COLOR.RED100.render(r, (RECTANGLE)this.body);
/* 264 */                   OPACITY.unbind();
/*     */                 } 
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 270 */                 if (MessDemand.Demand.this.canPay()) {
/* 271 */                   MessDemand.Demand.this.payed = true;
/* 272 */                   MessDemand.Demand.this.pay();
/* 273 */                   (GAME.raiders()).current.clear();
/* 274 */                   VIEW.messages().hide();
/*     */                   
/* 276 */                   (new MessDemandTY(MessDemand.Demand.this.raider)).send();
/*     */                 } 
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 283 */                 MessDemand.Demand.this.hoverInfoGet(text);
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 288 */         bb.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(MessDemand.¤¤decline)
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 292 */                 if (MessDemand.Demand.this.declined) {
/* 293 */                   selectedSet(true);
/*     */                 } else {
/* 295 */                   activeSet((!MessDemand.Demand.this.payed && (GAME.raiders()).current.canPay(MessDemand.Demand.this.iteration)));
/*     */                 } 
/*     */               }
/*     */               
/*     */               protected void clickA() {
/* 300 */                 MessDemand.Demand.this.declined = true;
/* 301 */                 VIEW.messages().hide();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 306 */         s.addRelBody(16, DIR.S, (RENDEROBJ)bb);
/*     */       } 
/*     */ 
/*     */       
/* 310 */       return (RENDEROBJ)s;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class DEntries
/*     */   {
/* 321 */     private final ArrayListGrower<MessDemand.DEntry> all = new ArrayListGrower();
/*     */     
/*     */     private final Tree<MessDemand.DEntry> rtree;
/*     */     
/*     */     DEntries() {
/* 326 */       for (TRADABLE res : TR.ALL()) {
/* 327 */         this.all.add(new MessDemand.DEntry()
/*     */             {
/*     */               int max()
/*     */               {
/* 331 */                 return (int)(res.ps().playerOwned() * 0.95D);
/*     */               }
/*     */ 
/*     */               
/*     */               void add(MessDemand.Demand d, int am) {
/* 336 */                 d.resources[res.index()] = d.resources[res.index()] + am;
/*     */               }
/*     */ 
/*     */               
/*     */               double value() {
/* 341 */                 return FWorth.worthResource(res, 1);
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 346 */       this.rtree = new Tree<MessDemand.DEntry>(this.all.size())
/*     */         {
/*     */           protected boolean isGreaterThan(MessDemand.DEntry current, MessDemand.DEntry cmp)
/*     */           {
/* 350 */             return (current.value > cmp.value);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     void set(MessDemand.Demand d, int credits) {
/* 357 */       this.rtree.clear();
/* 358 */       for (MessDemand.DEntry e : this.all) {
/* 359 */         e.value = (int)(e.value() * e.max() * RND.rFloat1(0.5D));
/* 360 */         if (e.value > 0) {
/* 361 */           this.rtree.add(e);
/*     */         }
/*     */       } 
/* 364 */       if (FACTIONS.player().credits().getD() > 0.0D) {
/* 365 */         int cre = (int)(FACTIONS.player().credits().getD() * RND.rFloat());
/* 366 */         if (cre > credits)
/* 367 */           cre = credits; 
/* 368 */         d.credits += cre;
/* 369 */         credits -= cre;
/*     */       } 
/*     */       
/* 372 */       while (credits > 0 && this.rtree.hasMore()) {
/* 373 */         MessDemand.DEntry e = (MessDemand.DEntry)this.rtree.pollGreatest();
/*     */         
/* 375 */         int am = e.max();
/* 376 */         int v = (int)e.value();
/* 377 */         int w = e.max() * v;
/* 378 */         if (w > credits)
/* 379 */           am = (int)Math.ceil(credits / v); 
/* 380 */         e.add(d, am);
/* 381 */         credits -= am * v;
/*     */       } 
/*     */       
/* 384 */       if (credits > 0) {
/* 385 */         int am = (int)(FACTIONS.player().credits().getD() - d.credits);
/* 386 */         if (am > credits)
/* 387 */           am = credits; 
/* 388 */         if (am > 0)
/* 389 */           d.credits += am; 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class DEntry {
/*     */     int value;
/*     */     int current;
/*     */     
/*     */     abstract void add(MessDemand.Demand param1Demand, int param1Int);
/*     */     
/*     */     abstract int max();
/*     */     
/*     */     abstract double value();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDemand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */