/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ public class NPCStockpileDebugUI extends GuiSection {
/*  25 */   public int[] tamounts = Alloc.ii(TR.ALL().size());
/*     */ 
/*     */   
/*     */   public NPCStockpileDebugUI(final FactionNPC faction) {
/*  29 */     int HEIGHT = 800;
/*     */     
/*  31 */     add((RENDEROBJ)table(faction, HEIGHT - 132));
/*     */ 
/*     */     
/*  34 */     GuiSection s = new GuiSection();
/*     */     
/*  36 */     s.addRightC(2, (RENDEROBJ)new GButt.ButtPanel("update")
/*     */         {
/*     */           protected void clickA() {
/*  39 */             for (int i = 0; i < NPCStockpileDebugUI.this.tamounts.length; i++) {
/*  40 */               faction.stockpile.res((TRADABLE)TR.ALL().get(i)).inc(NPCStockpileDebugUI.this.tamounts[i]);
/*  41 */               NPCStockpileDebugUI.this.tamounts[i] = 0;
/*     */             } 
/*     */             
/*  44 */             faction.stockpile.update(faction, 0.0D);
/*     */           }
/*     */         });
/*     */     
/*  48 */     s.addRightC(2, (RENDEROBJ)new GButt.ButtPanel("update day")
/*     */         {
/*     */           protected void clickA() {
/*  51 */             for (int i = 0; i < NPCStockpileDebugUI.this.tamounts.length; i++) {
/*  52 */               faction.stockpile.res((TRADABLE)TR.ALL().get(i)).inc(NPCStockpileDebugUI.this.tamounts[i]);
/*  53 */               NPCStockpileDebugUI.this.tamounts[i] = 0;
/*     */             } 
/*  55 */             faction.stockpile.update(faction, TIME.secondsPerDay());
/*     */           }
/*     */         });
/*     */     
/*  59 */     s.addRightC(2, (RENDEROBJ)new GButt.ButtPanel("clear")
/*     */         {
/*     */           protected void clickA() {
/*  62 */             faction.stockpile.saver().clear();
/*  63 */             faction.stockpile.update(faction, 0.0D);
/*  64 */             for (int i = 0; i < NPCStockpileDebugUI.this.tamounts.length; i++) {
/*  65 */               NPCStockpileDebugUI.this.tamounts[i] = 0;
/*     */             }
/*     */           }
/*     */         });
/*     */     
/*  70 */     addRelBody(2, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/*  74 */     s = new GuiSection();
/*  75 */     s.addRightC(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  79 */             GFORMAT.perc(text, faction.stockpile.creditScore());
/*     */           }
/*  81 */         }).hh("score"));
/*  82 */     s.addRightC(120, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  86 */             GFORMAT.i(text, (long)faction.credits().credits());
/*     */           }
/*  88 */         }).hh("cash"));
/*     */     
/*  90 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/*  94 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/*  99 */           return 200000000;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 104 */           return (int)faction.credits().getD() + 100000000;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 109 */           faction.credits().set((t - 100000000));
/*     */         }
/*     */       };
/*     */     
/* 113 */     s.addRightC(120, (RENDEROBJ)new GSliderInt(in, 200, true));
/*     */     
/* 115 */     s.addRightC(120, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 119 */             GFORMAT.i(text, (long)faction.stockpile.credit());
/*     */           }
/* 121 */         }).hh("worth"));
/* 122 */     addRelBody(2, DIR.S, (RENDEROBJ)s);
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
/*     */   
/*     */   private GuiSection table(final FactionNPC faction, int height) {
/* 138 */     GuiSection section = new GuiSection();
/*     */     
/* 140 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 144 */           return TR.ALL().size();
/*     */         }
/*     */       };
/*     */     
/* 148 */     bu.column("", 32, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 152 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 156 */                   TRADABLE re = (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue());
/* 157 */                   re.icon().render(r, (RECTANGLE)this.body);
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/* 163 */     bu.column("rate", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 167 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 171 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 172 */                   GFORMAT.f(text, res.rate());
/*     */                 }
/* 174 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 178 */     bu.column("rateT", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 182 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 186 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 187 */                   GFORMAT.f(text, res.rateTot());
/*     */                 }
/* 189 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 193 */     bu.column("traded", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 197 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 201 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 202 */                   GFORMAT.f(text, res.offset());
/*     */                 }
/* 204 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 208 */     bu.column("amTarget", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 212 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 216 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 217 */                   GFORMAT.f(text, res.amountTarget());
/*     */                 }
/* 219 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 223 */     bu.column("amTot", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 227 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 231 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 232 */                   GFORMAT.f(text, res.amountTarget() + res.offset());
/*     */                 }
/* 234 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 238 */     bu.column("tradable", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 242 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 246 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 247 */                   GFORMAT.f(text, res.amount());
/*     */                 }
/* 249 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 253 */     bu.column("priceMul", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 257 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 261 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 262 */                   GFORMAT.f(text, res.amMulAt(0));
/*     */                 }
/* 264 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     bu.column("priceB", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 276 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 280 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 281 */                   GFORMAT.f(text, res.priceBase());
/*     */                 }
/* 283 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 289 */     bu.column("S-price", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 293 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 297 */                   GFORMAT.f(text, faction.seller((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())).removePrice(1));
/*     */                 }
/* 299 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 303 */     bu.column("B-price", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 307 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 311 */                   GFORMAT.f(text, faction.buyer((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())).addPrice(1));
/*     */                 }
/* 313 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 317 */     bu.column("trade", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 321 */             INT.INTE in = new INT.INTE()
/*     */               {
/*     */                 public int min()
/*     */                 {
/* 325 */                   NPCRes res = faction.stockpile.res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 326 */                   return -((int)res.amount());
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int max() {
/* 331 */                   return 1000000;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public int get() {
/* 336 */                   return (NPCStockpileDebugUI.null.access$0(NPCStockpileDebugUI.null.this)).tamounts[((Integer)ier.get()).intValue()];
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void set(int t) {
/* 341 */                   (NPCStockpileDebugUI.null.access$0(NPCStockpileDebugUI.null.this)).tamounts[((Integer)ier.get()).intValue()] = t;
/*     */                 }
/*     */               };
/*     */             
/* 345 */             return (RENDEROBJ)new GInputInt(in);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 352 */     section.add((RENDEROBJ)bu.createHeight(height, true));
/* 353 */     faction.stockpile.update(faction, 0.0D);
/* 354 */     return section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpileDebugUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */