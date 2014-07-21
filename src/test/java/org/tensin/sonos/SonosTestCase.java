package org.tensin.sonos;

import com.beust.jcommander.ParameterException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tensin.sonos.commander.CLIController;
import org.tensin.sonos.commands.ZoneCommandDispatcher;
import org.tensin.sonos.commands.ZoneCommandExecutor;
import org.tensin.sonos.helpers.SystemHelper;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

/**
 * The Class CLITestCase.
 */
public class SonosTestCase {
    public static final String ZONE1 = "living room";
    public static final String ZONE2 = "kitchen";

    /** The zone command dispatcher. */
    private final ZoneCommandDispatcher zoneCommandDispatcher = ZoneCommandDispatcher.getInstance();

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        // SystemHelper mockedHelper = mock(SystemHelper.class);
        // doNothing().when(mockedHelper);
        final SystemHelper systemHelper = new SystemHelper();
        final SystemHelper spy = spy(systemHelper);
        doNothing().when(spy).exit(0);
        CLIController.setSystemHelper(spy);

        // SonosFactory.setiSonosClass(SonosMock.class);
        // DiscoverFactory.setiDiscoverClass(DiscoverMock.class);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() throws SonosException {
        zoneCommandDispatcher.resetInstance();
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testDiscover() throws SonosException {
        CLIController.main(new String[] { "--command", "discover" });
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testDummyCommand() throws SonosException {
        CLIController.main(new String[] { "zzz" });
    }

    /**
     * Test list.
     * (1) id: A: / Attributes
     * (2) id: S: / Music Shares
     * (3) id: Q: / Queues
     * (4) id: SQ: / Saved Queues
     * (5) id: R: / Internet Radio
     * (6) id: EN: / Entire Network
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testList() throws SonosException {
        CLIController.main(new String[] { "--command", "list", "A:", "--zone", ZONE1});
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testMute() throws SonosException {
        CLIController.main(new String[] { "--command", "mute", "--zone", ZONE1});

        ZoneCommandExecutor executor = zoneCommandDispatcher.getZoneCommandExecutor(ZONE1);
        Assert.assertTrue(executor != null);
        Assert.assertEquals(1, executor.getExecutedCommandsCount());

        executor = zoneCommandDispatcher.getZoneCommandExecutor(ZONE2);
        Assert.assertTrue(executor != null);
        Assert.assertEquals(0, executor.getExecutedCommandsCount());
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testNext() throws SonosException {
        CLIController.main(new String[] { "--command", "next", "--zone", ZONE2});
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testPause() throws SonosException {
        CLIController.main(new String[] { "--command", "pause", "--zone", "ALL" });
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testPlay() throws SonosException {
        CLIController.main(new String[] { "--command", "play", "--zone", ZONE1});
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testUnknownCommand() throws SonosException {
        try {
            CLIController.main(new String[] { "--zzz" });
        } catch (final ParameterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testUnknownOption() throws SonosException {
        CLIController.main(new String[] { "--command", "dis" });
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testUnknownZone() throws SonosException {
        CLIController.main(new String[] { "--command", "mute", "--zone", "zzzzzzzzzz" });
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testUnmute() throws SonosException {
        CLIController.main(new String[] { "--command", "unmute", "--zone", ZONE1});
    }

    /**
     * Test cli.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testUsage() throws SonosException {
        CLIController.main(new String[] { "--usage" });
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testVolume() throws SonosException {
        CLIController.main(new String[] { "--command", "volume", "--zone", ZONE2});
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testVolumeDown() throws SonosException {
        CLIController.main(new String[] { "--command", "down", "--zone", ZONE2});
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testVolumeSet() throws SonosException {
        CLIController.main(new String[] { "--command", "volume", "25", "--zone", ZONE2});
    }

    /**
     * Test next.
     *
     * @throws org.tensin.sonos.SonosException
     *             the sonos exception
     */
    @Test
    public void testVolumeUp() throws SonosException {
        CLIController.main(new String[] { "--command", "up", "--zone", ZONE2});
    }

}
